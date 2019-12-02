package com.example.c0761706_f2019_mad3125_midterm.Shared;

import com.example.c0761706_f2019_mad3125_midterm.Models.CRACustomer;
import com.example.c0761706_f2019_mad3125_midterm.Models.Detail;
import com.example.c0761706_f2019_mad3125_midterm.Models.HomeDetail;
import com.example.c0761706_f2019_mad3125_midterm.Utilities.DetailCustomer;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final DataManager ourInstance = new DataManager();

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {}

    public static List<HomeDetail> getHomeDetails() {
        List<HomeDetail> detailList = new ArrayList<>();
        CRACustomer customer1 = new CRACustomer("123456789", "John", "Doe", "12-Dec-1999", "Male", "100000", "20000");
        List<Detail> detail = DetailCustomer.getDetails(customer1);
        HomeDetail dummy = new HomeDetail(customer1.getSin(), customer1.fullName(), detail);
        detailList.add(dummy);
        return detailList;
    }
}
