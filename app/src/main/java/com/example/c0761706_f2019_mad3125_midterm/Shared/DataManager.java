package com.example.c0761706_f2019_mad3125_midterm.Shared;

import android.util.Log;

import com.example.c0761706_f2019_mad3125_midterm.Models.CRACustomer;
import com.example.c0761706_f2019_mad3125_midterm.Models.Detail;
import com.example.c0761706_f2019_mad3125_midterm.Models.HomeDetail;
import com.example.c0761706_f2019_mad3125_midterm.Utilities.DetailCustomer;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static List<HomeDetail> detailList;

    private static final DataManager ourInstance = new DataManager();

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
        detailList = new ArrayList<>();
        CRACustomer customer1 = new CRACustomer("123456789", "John", "Doe", "12-Dec-1999", "Male", "100000", "20000");
        addNewCustomer(customer1);
        CRACustomer customer2 = new CRACustomer("987654321", "David", "Warner", "09-Jan-2000", "FeMale", "200000", "18000");
        addNewCustomer(customer2);
        CRACustomer customer3 = new CRACustomer("567438787", "Ramanpreet", "Singh", "30-Nov-1997", "Male", "80000", "16000");
        addNewCustomer(customer3);
    }

    public static void addNewCustomer(CRACustomer customer) {
        List<Detail> detail1 = DetailCustomer.getDetails(customer);
        HomeDetail homeDetail = new HomeDetail(customer.getSin(), customer.fullName(), detail1);
        detailList.add(homeDetail);
    }

    public static List<HomeDetail> getHomeDetails() {
        return detailList;
    }
}
