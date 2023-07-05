package com.ucuncuoglu.HW2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.MyViewHolder> {
    Context context;
    public ProfileRecyclerViewAdapter(Context context, List<profile> data) {
        this.context = context;
        Commons.data=(ArrayList<profile>) data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.profile_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //BIND DATA
        final profile pro = Commons.data.get(position);
        holder.tvName.setText(pro.getName()+"\n");

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String msg = "  Profile NAME: " +pro.getName()
                        +"\n  Profile DAY:  "+pro.getDay()
                        +"\n  Product MONTH:  "+pro.getMonth()
                        +"\n  Product ASTRO:  "+pro.getAstroSign();
                ((showProfiles)context).displayDialog(msg);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Commons.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageButton btnDetail;
        TextView tvName;
        ImageView icon;

        MyViewHolder(View viewItem){
            super(viewItem);
            tvName = viewItem.findViewById(R.id.tvName);
            btnDetail = viewItem.findViewById(R.id.btnDetail);
        }
    }
}
