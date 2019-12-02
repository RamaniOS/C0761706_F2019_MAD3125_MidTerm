package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;

import com.example.c0761706_f2019_mad3125_midterm.Models.CRACustomer;
import com.example.c0761706_f2019_mad3125_midterm.R;
import com.example.c0761706_f2019_mad3125_midterm.Utilities.DetailCustomer;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DetailEditActivity extends AppCompatActivity {

    private TextInputEditText txtSIN;
    private TextInputEditText txtFName;
    private TextInputEditText txtLName;
    private TextInputEditText txtBirthDate;
    private TextInputEditText txtGrossIncome;
    private TextInputEditText txtRRSP;
    private Button btnCalculate;
    private DatePickerDialog datePickerDialog;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edit);
        initViews();
    }

    private void initViews() {
        txtSIN = findViewById(R.id.txtSin);
        txtFName = findViewById(R.id.txtFName);
        txtLName = findViewById(R.id.txtLName);
        txtBirthDate = findViewById(R.id.txtBirthDate);
        txtGrossIncome = findViewById(R.id.txtGross);
        txtRRSP = findViewById(R.id.txtRRSP);
        btnCalculate = findViewById(R.id.btnCalculate);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonChanged(checkedId);
            }
        });
        txtBirthDate.setInputType(InputType.TYPE_NULL);
        txtBirthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                }
            }
        });
        txtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateButtonClicked();
            }
        });
    }

    private void openDatePicker() {

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        datePickerDialog = new DatePickerDialog(DetailEditActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                        String strDate = format.format(calendar.getTime());
                        txtBirthDate.setText(strDate.toUpperCase());
                    }
                }, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        datePickerDialog.show();
    }

    private void onRadioButtonChanged(int checkedId) {
        switch (checkedId) {
            case R.id.radioMale:
                Log.d("kk", "MALE");
                break;
            case R.id.radioFeMale:
                Log.d("ll", "FEMALE");
                break;
            case R.id.radioOther:
                Log.d("kk", "OTHER");
                break;
        }
    }

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void calculateButtonClicked() {
        String sin = txtSIN.getText().toString();
        String fName = txtFName.getText().toString();
        String lName = txtLName.getText().toString();
        String dob = txtBirthDate.getText().toString();
        String gender = "MALE";
        String gross = txtGrossIncome.getText().toString();
        String rrsp = txtRRSP.getText().toString();

        CRACustomer customer = new CRACustomer(sin, fName, lName, dob, gender, gross, rrsp);
        List list = DetailCustomer.getDetails(customer);
        Intent intent = new Intent(this, ShowDetailActivity.class);
        intent.putParcelableArrayListExtra("details", (ArrayList<? extends Parcelable>) list);
        startActivity(intent);
    }
}
