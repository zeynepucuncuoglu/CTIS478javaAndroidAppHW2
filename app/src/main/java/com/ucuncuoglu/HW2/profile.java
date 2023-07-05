package com.ucuncuoglu.HW2;

import android.os.Parcel;
import android.os.Parcelable;

public class profile implements Parcelable {
    private String name;
    private int day;
    private String month;
    private String astroSign;

    public profile(String name, int day, String month, String astroSign) {
        this.name = name;
        this.day=day;
        this.month=month;
        this.astroSign=astroSign;
    }

    protected profile(Parcel in){
        name = in.readString();
        day = in.readInt();
        month = in.readString();
        astroSign = in.readString();
    }

    public static final Creator<profile> CREATOR = new Creator<profile>() {
        @Override
        public profile createFromParcel(Parcel in) {
            return new profile(in);
        }

        @Override
        public profile[] newArray(int size) {
            return new profile[size];
        }
    };

    public String getAstroSign() {
        return astroSign;
    }

    public void setAstroSign(String astroSign) {
        this.astroSign = astroSign;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(day);
        parcel.writeString(month);
        parcel.writeString(astroSign);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
