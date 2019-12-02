package com.example.c0761706_f2019_mad3125_midterm.Models;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

@SuppressLint("ParcelCreator")
public class HomeDetail implements Parcelable {

    private String sin;
    private String name;
    private List<Detail> detail;

    protected HomeDetail(Parcel in) {
        sin = in.readString();
        name = in.readString();
        detail = in.createTypedArrayList(Detail.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sin);
        dest.writeString(name);
        dest.writeTypedList(detail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HomeDetail> CREATOR = new Creator<HomeDetail>() {
        @Override
        public HomeDetail createFromParcel(Parcel in) {
            return new HomeDetail(in);
        }

        @Override
        public HomeDetail[] newArray(int size) {
            return new HomeDetail[size];
        }
    };

    public String getSin() {
        return sin;
    }

    public String getName() {
        return name;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public HomeDetail(String sin, String name, List<Detail> detail) {
        this.sin = sin;
        this.name = name;
        this.detail = detail;
    }
}
