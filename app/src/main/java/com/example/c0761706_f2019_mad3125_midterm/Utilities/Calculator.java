package com.example.c0761706_f2019_mad3125_midterm.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calculator {

    private static final int MAX_CPPAMOUNT = 57400;
    private static final double CPPAMOUNT_DEFAULT = 2927.4;
    private static final int MAX_EIAMOUNT = 53100;
    private static final double EIAMOUNT_DEFAULT = 860.22;

    private Calculator() {
    }

    public static String getAge(String birthDate) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            date = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) return "0";
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dob.setTime(date);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        return String.valueOf(age);
    }

    public static String performCPP(String income) {
        double gross = Double.parseDouble(income);
        if (gross > MAX_CPPAMOUNT) {
            return String.valueOf(CPPAMOUNT_DEFAULT);
        } else {
            double value = (gross * 5.10) / 100;
            return String.valueOf(value);
        }
    }

    public static String performEI(String income) {
        double gross = Double.parseDouble(income);
        if (gross > MAX_EIAMOUNT) {
            return String.valueOf(EIAMOUNT_DEFAULT);
        } else {
            double value = (gross * 1.62) / 100;
            double roundOff = Math.round(value * 100.0) / 100.0;
            return String.valueOf(roundOff);
        }
    }

    public static String performProvinceTax(String income) {
        double taxAble = Double.parseDouble(income.replace("$", ""));
        double totalTax = 0;
        if (taxAble > 10582.0) {
            taxAble -= 10582;
            totalTax = 0;
            if (taxAble > 43906) {
                totalTax += (33323.99 * 5.05) / 100;
                taxAble -= 33323.99;
                if (taxAble > 87813) {
                    totalTax += (43906.99 * 9.15) / 100;
                    taxAble -= 43906.99;
                    if (taxAble > 150000) {
                        totalTax += (62186.99 * 11.16) / 100;
                        taxAble -= 62186.99;
                        if (taxAble > 220000) {
                            totalTax += (69999.99 * 12.16) / 100;
                            taxAble -= 69999.99;
                            if (taxAble > 220000.01) {
                                totalTax += (taxAble * 12.16) / 100;
                            }
                        } else {
                            totalTax += (taxAble * 12.16) / 100;
                        }
                    } else {
                        totalTax += (taxAble * 11.16) / 100;
                    }
                } else {
                    totalTax += (taxAble * 9.15) / 100;
                }
            } else {
                totalTax += (taxAble * 5.05) / 100;
            }
        }
        double roundOff = Math.round(totalTax * 100.0) / 100.0;
        return "$" + roundOff;
    }


    public static String performFedralTax(String income) {
        double taxAble = Double.parseDouble(income.replace("$", ""));
        double totalTax = 0;
        if (taxAble > 12069) {
            taxAble -= 12069;
            totalTax = 0;
            if (taxAble > 47630) {
                totalTax += (35561 * 15) / 100;
                taxAble -= 35561;
                if (taxAble > 95259) {
                    totalTax += (47628.99 * 20.50) / 100;
                    taxAble -= 47628.99;
                    if (taxAble > 147667) {
                        totalTax += (52407.99 * 26) / 100;
                        taxAble -= 52407.99;
                        if (taxAble > 210371) {
                            totalTax += (62703.99 * 29) / 100;
                            taxAble -= 62703.99;
                            if (taxAble > 210371.01) {
                                totalTax += (taxAble * 33) / 100;
                            }
                        } else {
                            totalTax += (taxAble * 29) / 100;
                        }
                    } else {
                        totalTax += (taxAble * 26) / 100;
                    }
                } else {
                    totalTax += (taxAble * 20.50) / 100;
                }
            } else {
                totalTax += (taxAble * 15) / 100;
            }
        }
        double roundOff = Math.round(totalTax * 100.0) / 100.0;
        return "$" + roundOff;
    }
}
