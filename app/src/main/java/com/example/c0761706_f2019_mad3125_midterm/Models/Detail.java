package com.example.c0761706_f2019_mad3125_midterm.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Detail implements Parcelable {

    private String key;
    private String value;

    public Detail(String key, String value) {
        this.key = key;
        this.value = value;
    }

    protected Detail(Parcel in) {
        key = in.readString();
        value = in.readString();
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(value);
    }
}
