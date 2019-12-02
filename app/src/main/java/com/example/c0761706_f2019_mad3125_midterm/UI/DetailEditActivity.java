package com.example.c0761706_f2019_mad3125_midterm.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
    private RadioButton genderButton;

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

    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void calculateButtonClicked() {
        String sin = txtSIN.getText().toString();
        String fName = txtFName.getText().toString();
        String lName = txtLName.getText().toString();
        String dob = txtBirthDate.getText().toString();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderButton = findViewById(selectedId);
        String gender = genderButton.getText().toString();
        String gross = txtGrossIncome.getText().toString();
        String rrsp = txtRRSP.getText().toString();

        if (sin.trim().length() != 9) {
            showAlert("SIN Should be of 9 digits.");
        } else if (fName.trim().isEmpty()) {
            showAlert("Please enter First name");
        } else if (lName.trim().isEmpty()) {
            showAlert("Please enter Last name");
        } else if (dob.trim().isEmpty()) {
            showAlert("Please enter Date of birth");
        } else if (gross.trim().isEmpty()) {
            showAlert("Please enter Gross Income");
        } else if (rrsp.trim().isEmpty()) {
            showAlert("Please enter RRSP contribution");
        } else {
            CRACustomer customer = new CRACustomer(sin, fName, lName, dob, gender, gross, rrsp);
            List list = DetailCustomer.getDetails(customer);
            Intent intent = new Intent(this, ShowDetailActivity.class);
            intent.putParcelableArrayListExtra("details", (ArrayList<? extends Parcelable>) list);
            startActivity(intent);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void showAlert(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert!");
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setIcon(R.drawable.ic_action_alert);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
