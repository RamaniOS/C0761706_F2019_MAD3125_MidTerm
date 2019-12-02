package com.example.c0761706_f2019_mad3125_midterm.Utilities;

public class Calculator {

    private static final int MAX_CPPAMOUNT = 57400;
    private static final double CPPAMOUNT_DEFAULT = 2927.4;
    private static final int MAX_EIAMOUNT = 53100;
    private static final double EIAMOUNT_DEFAULT = 860.22;

    private Calculator() {}

    public static String performCPP(String income) {
        int gross = Integer.parseInt(income);
        if (gross > MAX_CPPAMOUNT) {
            return String.valueOf(CPPAMOUNT_DEFAULT);
        } else {
            double value = (gross * 5.10) / 100;
            return String.valueOf(value);
        }
    }

    public static String performEI(String income) {
        int gross = Integer.parseInt(income);
        if (gross > MAX_EIAMOUNT) {
            return String.valueOf(EIAMOUNT_DEFAULT);
        } else {
            double value = (gross * 1.62) / 100;
            return String.valueOf(value);
        }
    }
}
