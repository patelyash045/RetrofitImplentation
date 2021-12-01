package com.uktechians.retrofitimplentation.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.uktechians.retrofitimplentation.R;
import com.uktechians.retrofitimplentation.reqresData.Datum;

import java.util.List;

public class RetroAdapter extends RecyclerView.Adapter<RetroAdapter.RetroViewHolder> {

    private final Context context;
    private final List<Datum> datumList;
    public RetroAdapter(Context context, List<Datum> datumList){
        this.context = context;
        this.datumList = datumList;
    }



    @Override
    public RetroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout, parent,false);
        return new RetroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RetroViewHolder holder, int position) {

        Datum datum = datumList.get(position);
        holder.profileFname.setText(datum.getFirstName());
        holder.profileLname.setText(datum.getLastName());

        //solution for image show
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public static class RetroViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage;
        TextView profileFname;
        TextView profileLname;

        public RetroViewHolder(View itemView) {

            super(itemView);

            profileImage = (ImageView) itemView.findViewById(R.id.profileImage);
            profileFname = (TextView) itemView.findViewById(R.id.profileFname);
            profileLname = (TextView) itemView.findViewById(R.id.profileLname);

        }
    }
}
