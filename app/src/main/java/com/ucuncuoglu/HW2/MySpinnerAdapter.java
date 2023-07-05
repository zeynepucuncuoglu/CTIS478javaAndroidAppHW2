package com.ucuncuoglu.HW2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;


public class MySpinnerAdapter extends ArrayAdapter<spinItem> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;
    private ArrayList<spinItem> zodiacList;

    private boolean flag=false;

    public MySpinnerAdapter(Context baseContext, int histplacesspinner_layout, ArrayList<spinItem> mArrayList) {
        super(baseContext, histplacesspinner_layout, mArrayList);
        this.context = baseContext;
        this.layoutResourceId = histplacesspinner_layout;
        this.zodiacList = mArrayList;
    }

    /*
    Alternative solution - 2 nd way
    public MySpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource, HistoricalPlacesSys.getHistorialPlaces()); //Do not forget to call super class constructor. By the help of it, now adapter know that howmany times getView method will be called.
        this.context = context;
        this.layoutResourceId = resource;
    }
    */
    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflator.inflate(layoutResourceId,parent,false);
        }

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemLayout);
        TextView tv_main = rowView.findViewById(R.id.tvItemMain);
        ImageView leftPic = rowView.findViewById(R.id.imgItemleftPic);

        if(flag)
            itemLayout.setBackgroundColor(Color.MAGENTA);
        else
            itemLayout.setBackgroundColor(Color.GREEN);

        tv_main.setText(zodiacList.get(position).getName());
        leftPic.setImageResource(zodiacList.get(position).getImgId());

        return rowView;
    }

}
