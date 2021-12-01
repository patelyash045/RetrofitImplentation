package com.uktechians.retrofitimplentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.uktechians.retrofitimplentation.adapter.RetroAdapter;
import com.uktechians.retrofitimplentation.reqresAPI.RetrofitClient;
import com.uktechians.retrofitimplentation.reqresAPI.WebAPIs;
import com.uktechians.retrofitimplentation.reqresData.ReqresModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.profileList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataFromAPI();
    }


    private void getDataFromAPI() {

        WebAPIs api = RetrofitClient.getInstance().getClient().create(WebAPIs.class);
        api.call("2").enqueue(new Callback<ReqresModel>() {
            @Override
            public void onResponse(Call<ReqresModel> call, Response<ReqresModel> response) {
                if (response.code() == 200 && response.isSuccessful()) {
                    if (response.body() != null && response.body().getData().size() > 0) {

                        ReqresModel list = response.body();
                        recyclerView.setAdapter(new RetroAdapter(MainActivity.this,list.getData()));

                        Toast.makeText(MainActivity.this, response.body().getData() + "", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, response.message() + "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReqresModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });


    }
}