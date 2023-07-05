package com.ucuncuoglu.HW2;

import android.database.Cursor;

import java.util.ArrayList;

public class Commons {
        public static profile profile;
        public static Cursor cursor;
        public static ArrayList<profile> data;

        public static profile getProfile() {
            return profile;
        }

        public static void setProfile(profile profile) {
            Commons.profile = profile;
        }

        public static ArrayList<profile> getData() {
            return data;
        }

        public static void setData(ArrayList<profile> data) {
            Commons.data = data;
        }
}
