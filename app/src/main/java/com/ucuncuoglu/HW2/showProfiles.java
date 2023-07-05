package com.ucuncuoglu.HW2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class showProfiles extends AppCompatActivity {

    Intent intent;
    RecyclerView recylerPro;
    DatabaseHelper dbHelper;
    Dialog customDialog;
    ProfileRecyclerViewAdapter adapter;
    profile p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profiles);
        // Hiding title bar using code
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        dbHelper = new DatabaseHelper(this);
        customDialog = new Dialog(this );

        intent = getIntent();
        Bundle b = intent.getExtras();
        p=b.getParcelable("object");


        profileTable.insertPro(dbHelper,p.getName(), p.getDay(), p.getMonth(),p.getAstroSign());
        Commons.data = (ArrayList<profile>) profileTable.getAllProducts(dbHelper);
        adapter = new ProfileRecyclerViewAdapter(this, Commons.data);
        recylerPro = findViewById(R.id.recylerPro);
        recylerPro.setAdapter(adapter);
    }

    public void displayDialog(final String msg){
        final TextView tv;
        Button btnClose;

        customDialog = new Dialog(this);

        customDialog.setContentView(R.layout.dialog);
        tv =  customDialog.findViewById(R.id.tvDialogName);
        btnClose = customDialog.findViewById(R.id.btnClose);
        tv.setText(msg+"");

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });
        customDialog.show();
    }
}