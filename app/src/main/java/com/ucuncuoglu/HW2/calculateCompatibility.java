package com.ucuncuoglu.HW2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class calculateCompatibility extends AppCompatActivity {

    Spinner sign1;
    Spinner sign2;
    MySpinnerAdapter spinnerAdapter1, spinnerAdapter2;
    ArrayList<spinItem> mArrayList;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_compatibility);
        // Hiding title bar using code
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sign1  = findViewById(R.id.spinner);
        sign2= findViewById(R.id.spinner2);
        result = findViewById(R.id.result);

        spinSys.prepareData();

        spinnerAdapter1 = new MySpinnerAdapter(getBaseContext(), R.layout.spinner_layout, spinSys.getSpinList());
        sign1.setAdapter(spinnerAdapter1);
        sign1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerAdapter2 = new MySpinnerAdapter(getBaseContext(), R.layout.spinner_layout, spinSys.getSpinList());
        sign2.setAdapter(spinnerAdapter2);
        sign2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    public void onClick(View view){
        result.setText(" you are 100% compatible to each other.");

    }


}