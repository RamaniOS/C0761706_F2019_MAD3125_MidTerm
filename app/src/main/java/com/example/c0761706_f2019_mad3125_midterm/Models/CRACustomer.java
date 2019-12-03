package com.example.c0761706_f2019_mad3125_midterm.Models;


import android.util.Log;

import com.example.c0761706_f2019_mad3125_midterm.Utilities.Calculator;

import java.text.DateFormat;
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

    public String birthDateKey() {
        return "Birth Of Date";
    }

    public String genderKey() {
        return "Gender";
    }

    public String ageKey() {
        return "Age (Year)";
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
        return "Provincial Tax (Ontario)";
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

    public String fullName() {
        return lName.toUpperCase() + ", " + fName.toLowerCase();
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getGrossIncome() {
        return grossIncome;
    }

    public String getRrspConrtibuted() {
        return rrspConrtibuted;
    }

    public String getAge() {
        return Calculator.getAge(dob);
    }

    public String taxFilingDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate.toUpperCase();
    }

    public String getCPP() {
        if (grossIncome.trim().length() != 0)
            return "$" + Calculator.performCPP(getGrossIncome());
        else return "$0";
    }

    public String getEI() {
        if (grossIncome.trim().length() != 0)
            return "$" + Calculator.performEI(getGrossIncome());
        else return "$0";
    }

    public String getRemainingRSSP() {
        if (getRrspConrtibuted() == null) return "$0";
        double rrsp = Double.parseDouble(getRrspConrtibuted());
        double remaining = getMaxRRSP() - rrsp;
        return "$" + remaining;
    }

    public String getTotalTaxableAmount() {
        double cpp = Double.parseDouble(getCPP().replace("$", ""));
        double ei = Double.parseDouble(getEI().replace("$", ""));
        double contributed = Double.parseDouble(getRrspConrtibuted().replace("$", ""));
        if (contributed > getMaxRRSP()) {
            contributed = getMaxRRSP();
        }
        double total = cpp + ei + getMaxRRSP();
        double gross = Double.parseDouble(getGrossIncome());
        double totalTaxable = gross - total;
        double roundOff = Math.round(totalTaxable * 100.0) / 100.0;
        return "$" + roundOff;
    }

    public String getProviceTax() {
        return Calculator.performProvinceTax(getTotalTaxableAmount());
    }

    public String getFedralTax() {
        return Calculator.performFedralTax(getTotalTaxableAmount());
    }

    public String getTotalTax() {
        double pT = Double.parseDouble(getProviceTax().replace("$", ""));
        double fT = Double.parseDouble(getFedralTax().replace("$", ""));
        double roundOff = Math.round((pT+fT) * 100.0) / 100.0;
        return "$" + roundOff;
    }

    public double getMaxRRSP() {
        double income = Double.parseDouble(grossIncome);
        return (income * 18) / 100;
    }
}
