package com.ucuncuoglu.HW2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class menu extends AppCompatActivity {
    private String jsonStr;


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mRecyclerAdapter;
    DatabaseHelper dbHelper;

    private JSONArray zodiacs;
    private JSONObject zodiacJSONObject;
    private zodiac mZodiac;
    private profile person;


    Intent intent;
    TextView tvRes;

    EditText etKey;
    String key = "";


    private ArrayList<zodiac> mArrayList;
    private ArrayList<menuItem> m2ArrayList;

    public static final String TAG_ZODIACS = "zodiacs";
    public static final String TAG_NAME = "name";
    public static final String TAG_TIME = "time";
    public static final String TAG_STONE = "stone";
    public static final String TAG_COLOR = "color";
    public static final String TAG_ELEMENT = "element";
    public static final String TAG_PLANET = "planet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        tvRes = findViewById(R.id.deneme);

        intent = getIntent();

        Bundle b = intent.getExtras();
        String name = b.getString("name");
        String month = b.getString("month");
        int day = b.getInt("day");
        String astro = b.getString("astro");




        person = new profile(name, day, month, astro);

    }

    public void onClick(View v) {

        //key = etKey.getText().toString();
        m2ArrayList = new ArrayList<menuItem>();

        menuItem menuItem1 = new menuItem("show your zodiac sign features",R.drawable.features);
        menuItem menuItem2 = new menuItem("calculate compatibility", R.drawable.compatibility);
        menuItem menuItem3 = new menuItem("show profiles", R.drawable.profiles);
        m2ArrayList.add(menuItem1);
        m2ArrayList.add(menuItem2);
        m2ArrayList.add(menuItem3);

        mArrayList = new ArrayList<zodiac>();

        // Reading the JSON file from the raw folder and storing it in a String
        // jsonStr = loadFileFromRaw("books");
        //Log.d("TAG", "\n" + jsonStr);

        // Reading the JSON file from the assets folder and storing it in a String
        jsonStr = loadFileFromAssets("zodiacs.json");
        Log.d("TAG", "\n" + jsonStr);

        // Call to AsyncTask

        //day = Integer.parseInt(etM.getText().toString());
        int day = 2;

        new GetZodiacs().execute();


    }

    private class GetZodiacs extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Creating and showing the progress Dialog
            //mProgressBar.setVisibility(View.VISIBLE);
        }

        // Main job should be done here
        @Override
        protected Void doInBackground(Void... params) {
            //Log.d("TAG", "HERE.....");

            if (jsonStr != null) {
                try {
                    zodiacJSONObject = new JSONObject(jsonStr);
                    // Getting JSON Array
                    zodiacs = zodiacJSONObject.getJSONArray(TAG_ZODIACS);


                    // looping through all books
                    for (int i = 0; i < zodiacs.length(); i++) {

                        JSONObject jsonObj = zodiacs.getJSONObject(i);

                        //Thread.sleep(2000);//This is here only to simulate parsing json takes time so that ProgressBar execution can be displayed better

                        String name = jsonObj.getString(TAG_NAME);
                        String time = jsonObj.getString(TAG_TIME);
                        String stone = jsonObj.getString(TAG_STONE);
                        String color = jsonObj.getString(TAG_COLOR);
                        String element = jsonObj.getString(TAG_ELEMENT);
                        String planet = jsonObj.getString(TAG_PLANET);


                        zodiac x = new zodiac(name, time, stone, color, element, planet,1);


                        if(name.equals(name)){
                            mZodiac = new zodiac(name, time, stone, color, element, planet,1);
                        }

                        Log.d("KEY", key + " " + name);
                        if (key.isEmpty())
                            mArrayList.add(x);
                        else if (name.toLowerCase().contains(key.toLowerCase()))
                            mArrayList.add(x);
                    }
                } catch (JSONException ee) {
                    ee.printStackTrace();
                }
            }

            return null;
        }


        // What do you want to do after doInBackground() finishes
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Dismiss the progress dialog

            if (m2ArrayList != null) {
                addPictoZodiacs();
                mRecyclerAdapter = new RecyclerAdapter(menu.this ,m2ArrayList, mZodiac ,person);
                mRecyclerView.setAdapter(mRecyclerAdapter);
                tvRes.setText(mZodiac.getName());

            } else
                Toast.makeText(menu.this, "Not Found", Toast.LENGTH_LONG).show();
        }

    }

    private String loadFileFromRaw(String fileName) {
        String fileContent = null;
        try {
            InputStream is = getResources().openRawResource(
                    getResources().getIdentifier(fileName,
                            "raw", getPackageName()));
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            fileContent = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return fileContent;
    }

    private String loadFileFromAssets(String fileName) {
        String fileContent = null;
        try {
            InputStream is = getBaseContext().getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            fileContent = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return fileContent;
    }

    private void addPictoZodiacs(){
        mArrayList.get(0).setImgId(R.drawable.aries);
        mArrayList.get(1).setImgId(R.drawable.taurus);
        mArrayList.get(2).setImgId(R.drawable.gemini);
        mArrayList.get(3).setImgId(R.drawable.cancer);
        mArrayList.get(4).setImgId(R.drawable.leo);
        mArrayList.get(5).setImgId(R.drawable.virgo);
        mArrayList.get(6).setImgId(R.drawable.libra);
        mArrayList.get(7).setImgId(R.drawable.scorpio);
        mArrayList.get(8).setImgId(R.drawable.sagittarius);
        mArrayList.get(9).setImgId(R.drawable.capricorn);
        mArrayList.get(10).setImgId(R.drawable.aquarius);
        mArrayList.get(11).setImgId(R.drawable.pisces);
    }

}

