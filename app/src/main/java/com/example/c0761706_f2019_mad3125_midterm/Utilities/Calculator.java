package com.example.c0761706_f2019_mad3125_midterm.Utilities;

import android.util.Log;

public class Calculator {

    private static final int MAX_CPPAMOUNT = 57400;
    private static final double CPPAMOUNT_DEFAULT = 2927.4;
    private static final int MAX_EIAMOUNT = 53100;
    private static final double EIAMOUNT_DEFAULT = 860.22;

    private Calculator() {
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
            return String.valueOf(value);
        }
    }

    public static String performProvinceTax(String income) {
        double taxAble = Double.parseDouble(income.replace("$", ""));
        Log.d("TAx", String.valueOf(taxAble));
        double totalTax = 0;

        if (taxAble > 10582.0) {
            taxAble -= 10582;
            totalTax = 0;
            if (taxAble > 43906) {
                totalTax += (33323.99 * 5.05) / 100;
                taxAble -= 33323.99;
                Log.d("FIRST", String.valueOf(totalTax));
                if (taxAble > 87813) {
                    totalTax += (43906.99 * 9.15) / 100;
                    taxAble -= 43906.99;
                    Log.d("Third", String.valueOf(totalTax));
                    if (taxAble > 150000) {
                        totalTax += (62186.99 * 11.16) / 100;
                        taxAble -= 62186.99;
                        Log.d("five", String.valueOf(taxAble));
                        if (taxAble > 220000) {
                            totalTax += (69999.99 * 12.16) / 100;
                            taxAble -= 69999.99;
                            Log.d("sev", String.valueOf(taxAble));
                            if (taxAble > 220000.01) {
                                totalTax += (43906.99 * 12.16) / 100;
                                taxAble -= 43906.99;
                                Log.d("ei", String.valueOf(taxAble));
                            } else {
                                totalTax += (taxAble * 12.16) / 100;
                                Log.d("ni", String.valueOf(totalTax));
                            }
                        } else {
                            totalTax += (taxAble * 12.16) / 100;
                            Log.d("six", String.valueOf(totalTax));
                        }
                    } else {
                        totalTax += (taxAble * 11.16) / 100;
                        Log.d("six", String.valueOf(totalTax));

                    }
                } else {
                    totalTax += (taxAble * 9.15) / 100;
                    Log.d("Fou", String.valueOf(totalTax));
                }
            } else {
                totalTax += (taxAble * 5.05) / 100;
                Log.d("Sec", String.valueOf(totalTax));

            }
        }
        double roundOff = Math.round(totalTax * 100.0) / 100.0;
        return "$" + roundOff;
    }


    public static String performFedralTax(String income) {
        double taxAble = Double.parseDouble(income.replace("$", ""));
        Log.d("TAx", String.valueOf(taxAble));
        double totalTax = 0;

        if (taxAble > 10582.0) {
            taxAble -= 10582;
            totalTax = 0;
            if (taxAble > 43906) {
                totalTax += (33323.99 * 5.05) / 100;
                taxAble -= 33323.99;
                Log.d("FIRST", String.valueOf(totalTax));
                if (taxAble > 87813) {
                    totalTax += (43906.99 * 9.15) / 100;
                    taxAble -= 43906.99;
                    Log.d("Third", String.valueOf(totalTax));
                    if (taxAble > 150000) {
                        totalTax += (62186.99 * 11.16) / 100;
                        taxAble -= 62186.99;
                        Log.d("five", String.valueOf(taxAble));
                        if (taxAble > 220000) {
                            totalTax += (69999.99 * 12.16) / 100;
                            taxAble -= 69999.99;
                            Log.d("sev", String.valueOf(taxAble));
                            if (taxAble > 220000.01) {
                                totalTax += (43906.99 * 12.16) / 100;
                                taxAble -= 43906.99;
                                Log.d("ei", String.valueOf(taxAble));
                            } else {
                                totalTax += (taxAble * 12.16) / 100;
                                Log.d("ni", String.valueOf(totalTax));
                            }
                        } else {
                            totalTax += (taxAble * 12.16) / 100;
                            Log.d("six", String.valueOf(totalTax));
                        }
                    } else {
                        totalTax += (taxAble * 11.16) / 100;
                        Log.d("six", String.valueOf(totalTax));

                    }
                } else {
                    totalTax += (taxAble * 9.15) / 100;
                    Log.d("Fou", String.valueOf(totalTax));
                }
            } else {
                totalTax += (taxAble * 5.05) / 100;
                Log.d("Sec", String.valueOf(totalTax));

            }
        }
        double roundOff = Math.round(totalTax * 100.0) / 100.0;
        return "$" + roundOff;
    }
}
