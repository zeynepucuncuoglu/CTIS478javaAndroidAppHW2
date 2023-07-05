package com.ucuncuoglu.HW2;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class profileTable {
    public static final String TABLE_NAME="profile";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DAY = "day";
    public static final String FIELD_MONTH = "month";
    public static final String FIELD_SIGN = "astroSign";

    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_NAME
            +" text, "+FIELD_DAY+" number, "+FIELD_MONTH +" text ," + FIELD_SIGN + " text);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;


    public static List<profile> getAllProducts(DatabaseHelper db){

        Cursor cursor = db.getAllRecords(TABLE_NAME, null);
        //Cursor cursor  db.getAllRecordsMethod2("SELECT * FROM "+TABLE_NAME, null)
        List<profile> data=new ArrayList<>();
        profile pro = null;
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            int day = cursor.getInt(2);
            String month = cursor.getString(3);
            String astroSign = cursor.getString(4);

            pro= new profile(name,day,month,astroSign);
            data.add(pro);
        }
        return data;
    }
    public static List<profile> findPro(DatabaseHelper db, String key){

        String where = FIELD_NAME+" like '%"+key+"%'";
        Cursor cursor = db.getSomeRecords(TABLE_NAME,null, where);
        List<profile> data=new ArrayList<>();
        profile pro = null;
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            int day = cursor.getInt(2);
            String month = cursor.getString(3);
            String astroSign = cursor.getString(4);

            pro= new profile(name,day,month,astroSign);
            data.add(pro);
        }

        return data;
    }

    public static boolean insertPro(DatabaseHelper db, String name, int day, String month, String astroSign){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_DAY, day);
        contentValues.put(FIELD_MONTH, month);
        contentValues.put(FIELD_SIGN, astroSign);


        boolean res = db.insert(TABLE_NAME,contentValues);

        return res;
    }


}

