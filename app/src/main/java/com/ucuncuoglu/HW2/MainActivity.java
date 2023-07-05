package com.ucuncuoglu.HW2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText etD;
    EditText etM;
    EditText etN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hiding title bar using code
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        etM = findViewById(R.id.month);
        etD = findViewById(R.id.day);
        etN= findViewById(R.id.name);

        //day = Integer.parseInt(strDay);

        //etKey = findViewById(R.id.etKey);

    }

    public void onClick(View v) {

        // Call to AsyncTask

        int day = Integer.parseInt(etD.getText().toString());
        String month = etM.getText().toString();
        String strName = etN.getText().toString();

        String astro_sign = "capricorn";
       // findAstroSign(day,month);

        Log.d("TAG", "\n" + astro_sign);

        //sending infos to the menu activity

        Intent intent = new Intent(this, menu.class);
        Bundle b = new Bundle();
        b.putString("name",strName);
        b.putString("month",month);
        b.putInt("day",day);
        b.putString("astro",astro_sign);

        intent.putExtras(b);
        startActivity(intent);

    }


    private void makeAndShowDialogBox(String message) {
        AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);
        // set message, title, and icon
        myDialogBox.setTitle("Party Type");
        myDialogBox.setMessage(message);
        // Set three option buttons
        myDialogBox.setPositiveButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) { // whatever should be done when answering "YES" goes
// here
                    }
                });
        myDialogBox.create();
        myDialogBox.show();
    }

    public String findAstroSign(int day, String month){
        String astro_sign ="";

        if (month == "december"){

            if (day < 22)
                astro_sign = "Sagittarius";
            else
                astro_sign ="Capricorn";
        }

        else if (month == "january"){
            if (day < 20)
                astro_sign = "Capricorn";
            else
                astro_sign = "Aquarius";
        }

        else if (month == "february"){
            if (day < 19)
                astro_sign = "Aquarius";
            else
                astro_sign = "Pisces";
        }

        else if(month == "march"){
            if (day < 21)
                astro_sign = "Pisces";
            else
                astro_sign = "Aries";
        }
        else if (month == "april"){
            if (day < 20)
                astro_sign = "Aries";
            else
                astro_sign = "Taurus";
        }

        else if (month == "may"){
            if (day < 21)
                astro_sign = "Taurus";
            else
                astro_sign = "Gemini";
        }

        else if( month == "june"){
            if (day < 21)
                astro_sign = "Gemini";
            else
                astro_sign = "Cancer";
        }

        else if (month == "july"){
            if (day < 23)
                astro_sign = "Cancer";
            else
                astro_sign = "Leo";
        }

        else if( month == "august"){
            if (day < 23)
                astro_sign = "Leo";
            else
                astro_sign = "Virgo";
        }

        else if (month == "september"){
            if (day < 23)
                astro_sign = "Virgo";
            else
                astro_sign = "libra";
        }

        else if (month == "october"){
            if (day < 23)
                astro_sign = "Libra";
            else
                astro_sign = "Scorpio";
        }

        else if (month == "november"){
            if (day < 22)
                astro_sign = "Scorpio";
            else
                astro_sign = "Sagittarius";
        }

        return astro_sign;
    }
}