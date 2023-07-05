package com.ucuncuoglu.HW2;

import java.util.ArrayList;

public class spinSys {
    private static ArrayList<spinItem> spinList = new ArrayList();

    public static void prepareData(){
        spinList .add(new spinItem("aries", R.drawable.aries));
        spinList .add(new spinItem("taurus", R.drawable.taurus));
        spinList .add(new spinItem("gemini", R.drawable.gemini));
        spinList .add(new spinItem("cancer", R.drawable.cancer));
        spinList .add(new spinItem("leo", R.drawable.leo));
        spinList .add(new spinItem("virgo", R.drawable.virgo));
        spinList .add(new spinItem("libra", R.drawable.libra));
        spinList .add(new spinItem("scorpio", R.drawable.scorpio));
        spinList .add(new spinItem("sagittarius", R.drawable.sagittarius));
        spinList .add(new spinItem("capricorn", R.drawable.capricorn));
        spinList .add(new spinItem("aquarius", R.drawable.aquarius));
        spinList .add(new spinItem("pisces", R.drawable.pisces));


    }

    public static ArrayList<spinItem> getSpinList() {
        return spinList;
    }

    public static spinItem getItem(int selectedPos) {
        return spinList .get(selectedPos);
    }
}
