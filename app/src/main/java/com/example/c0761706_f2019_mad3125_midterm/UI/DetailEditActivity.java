package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.c0761706_f2019_mad3125_midterm.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class DetailEditActivity extends AppCompatActivity {

    private TextInputEditText txtSIN;
    private TextInputEditText txtFName;
    private TextInputEditText txtLName;
    private TextInputEditText txtBirthDate;
    private TextInputEditText txtGrossIncome;
    private TextInputEditText txtRRSP;
    private Button btnCalculate;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailedit);
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
        txtBirthDate.setInputType(InputType.TYPE_NULL);
        txtBirthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                }
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
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        datePickerDialog = new DatePickerDialog(DetailEditActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txtBirthDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void calculateButtonClicked() {

    }

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
