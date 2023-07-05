package com.ucuncuoglu.HW2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<menuItem> mArrayList;
    private zodiac astroSign;
    private profile person;


    String urlString;

    public RecyclerAdapter(Context mContext ,ArrayList<menuItem> mArrayList, zodiac z, profile p) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        this.astroSign = z;
        this.person=p;
    }

    // Each object of the ViewHolder will be created here
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = (View) mLayoutInflater.inflate(R.layout.item_layout, parent, false);
        ViewHolder mViewHolder = new ViewHolder(itemView);

        return mViewHolder;
    }

    public void openOtherActivity(Intent intent){
        Bundle b = new Bundle();
        b.putParcelable("Object", person);
        intent.putExtras(b);
        mContext.startActivity(intent);
    }
    // This method will be called to assign data to each row or cell

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        final menuItem menuitem = mArrayList.get(position);
        final Intent intent1 = new Intent(mContext,calculateCompatibility.class);
        final Intent intent2 = new Intent(mContext,showProfiles.class);

        int number = position;
        holder.title.setText(menuitem.getTitle());
        holder.image.setImageResource(menuitem.getImgId());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number == 0) {
                    String msg = astroSign.toString();
                    makeAndShowDialogBox(msg);

                } else if (number == 1) {
                    openOtherActivity(intent1);

                } else {
                    openOtherActivity(intent2);
                }
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number == 0) {
                    String msg = astroSign.toString();
                    makeAndShowDialogBox(msg);

                } else if (number == 1) {
                    openOtherActivity(intent1);

                } else {
                    openOtherActivity(intent2);
                }
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number == 0) {
                    String msg = astroSign.toString();
                    makeAndShowDialogBox(msg);

                } else if (number == 1) {
                    openOtherActivity(intent1);

                } else {
                    openOtherActivity(intent2);
                }
            }
        });
    }


    // How many items exist in the list
    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    // This class is responsible for each item on the list

    public class ViewHolder extends RecyclerView.ViewHolder {
        //implements View.OnClickListener
        TextView title;
        ImageView image;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.constraintLayout);
            title = (TextView) itemView.findViewById(R.id.tv);
            image = itemView.findViewById(R.id.iv);
        }


    }

    private void makeAndShowDialogBox(String message) {

        AlertDialog.Builder mDialogBox = new AlertDialog.Builder(mContext);

        mDialogBox.setTitle("features");
        mDialogBox.setMessage(message);

        mDialogBox.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {


                    }
                });

        mDialogBox.create();
        mDialogBox.show();
    }
}


