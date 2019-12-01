package com.example.c0761706_f2019_mad3125_midterm.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CRACustomer {

    private String sin;
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private String grossIncome;
    private String rrspConrtibuted;

    public CRACustomer(String sin, String fName, String lName, String dob, String gender, String grossIncome, String rrspConrtibuted) {
        this.sin = sin;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspConrtibuted = rrspConrtibuted;
    }

    public String sinKey() {
        return "Person SIN Number";
    }

    public String fullNameKey() {
        return "Full Name";
    }

    public String genderKey() {
        return "Gender";
    }

    public String ageKey() {
        return "Age";
    }

    public String taxDateKey() {
        return "Tax Filing date";
    }

    public String incomeKey() {
        return "Gross income";
    }

    public String rrspContributedKey() {
        return "RRSP Contributed";
    }

    public String fedralKey() {
        return "Federal tax";
    }

    public String provinceKey() {
        return "Provincial Tax";
    }

    public String cppKey() {
        return "CPP";
    }

    public String eiKey() {
        return "EI";
    }

    public String carryRRSPKey() {
        return "Carry forward RRSP";
    }

    public String totalPayableTaxKey() {
        return "Total Taxable Income";
    }

    public String totalPaidTaxKey() {
        return "Total Tax Payed";
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String fullName() {
        return lName.toUpperCase() + ", " + fName.toLowerCase();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public String getRrspConrtibuted() {
        return rrspConrtibuted;
    }

    public void setRrspConrtibuted(String rrspConrtibuted) {
        this.rrspConrtibuted = rrspConrtibuted;
    }

    public String getAge() {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(date == null) return "0";
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.setTime(date);
        int year = dob.get(Calendar.YEAR);
        int month = dob.get(Calendar.MONTH);
        int day = dob.get(Calendar.DAY_OF_MONTH);
        dob.set(year, month+1, day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return String.valueOf(age);
    }
}
