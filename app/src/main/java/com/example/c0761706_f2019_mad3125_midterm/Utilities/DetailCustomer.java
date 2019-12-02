package com.example.c0761706_f2019_mad3125_midterm.Utilities;

import com.example.c0761706_f2019_mad3125_midterm.Models.CRACustomer;
import com.example.c0761706_f2019_mad3125_midterm.Models.Detail;
import com.example.c0761706_f2019_mad3125_midterm.Models.HomeDetail;

import java.util.ArrayList;
import java.util.List;

public class DetailCustomer {

    private DetailCustomer() {}

    public static List<Detail> getDetails(CRACustomer customer) {
        List<Detail> detailList = new ArrayList<>();
        // sin
        Detail sinDetail = new Detail(customer.sinKey(), customer.getSin());
        detailList.add(sinDetail);
        // full name
        Detail fullName = new Detail(customer.fullNameKey(), customer.fullName());
        detailList.add(fullName);
        // dob
        Detail dob = new Detail(customer.birthDateKey(), customer.getDob());
        detailList.add(dob);
        // gender
        Detail gender = new Detail(customer.genderKey(), customer.getGender());
        detailList.add(gender);
        // age
        Detail age = new Detail(customer.ageKey(), customer.getAge());
        detailList.add(age);
        // tax filing date
        Detail taxFillingDate = new Detail(customer.taxDateKey(), customer.taxFilingDate());
        detailList.add(taxFillingDate);
        // total income
        Detail income = new Detail(customer.incomeKey(), "$" + customer.getGrossIncome());
        detailList.add(income);
        // federal tax
        Detail fTax = new Detail(customer.fedralKey(), customer.getFedralTax());
        detailList.add(fTax);
        // province tax
        Detail pTax = new Detail(customer.provinceKey(), customer.getProviceTax());
        detailList.add(pTax);
        // cpp
        Detail cpp = new Detail(customer.cppKey(), customer.getCPP());
        detailList.add(cpp);
        // EI
        Detail ei = new Detail(customer.eiKey(), customer.getEI());
        detailList.add(ei);
        // RRSP contributed
        Detail rrspCon = new Detail(customer.rrspContributedKey(), "$" + customer.getRrspConrtibuted());
        detailList.add(rrspCon);
        // RRSP carry forward
        Detail caryRRsp = new Detail(customer.carryRRSPKey(), customer.getRemainingRSSP());
        detailList.add(caryRRsp);
        // total payable income
        Detail totalPayIncome = new Detail(customer.totalPayableTaxKey(), customer.getTotalTaxableAmount());
        detailList.add(totalPayIncome);
        // total paid tax
        Detail totalPaidTax = new Detail(customer.totalPaidTaxKey(), customer.getTotalTax());
        detailList.add(totalPaidTax);
        return detailList;
    }

    public static List<HomeDetail> getHomeDetails() {
        List<HomeDetail> detailList = new ArrayList<>();
        CRACustomer customer1 = new CRACustomer("123456789", "John", "Doe", "12-Dec-1999", "Male", "100000", "20000");
        List<Detail> detail = getDetails(customer1);
        HomeDetail dummy = new HomeDetail(customer1.getSin(), customer1.fullName(), detail);
        detailList.add(dummy);
        return detailList;
    }
}
