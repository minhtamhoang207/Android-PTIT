package com.example.ptiit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.ptiit.RecycleViewExample.RecycleViewAdapterActivity;

import java.util.Calendar;

public class DateTimePickerActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    EditText edtDate, edtTime;
    Button buttonDate, buttonTime, buttonRecycleView;
    boolean is24HView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        initView();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, DateTimePickerActivity.this, 2001, 1, 1);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                DateTimePickerActivity.this, 24, 60, is24HView);

        buttonDate.setOnClickListener(view -> {
            datePickerDialog.show();
        });

        buttonTime.setOnClickListener(view -> {
            timePickerDialog.show();
        });

        buttonRecycleView.setOnClickListener(view -> {
            Intent myIntent = new Intent(this, RecycleViewAdapterActivity.class);
            this.startActivity(myIntent);
        });


    }

    void initView(){
        edtDate = findViewById(R.id.editTextDate);
        edtTime = findViewById(R.id.editTextTime);
        buttonDate = findViewById(R.id.buttonDate);
        buttonTime = findViewById(R.id.buttonTime);
        buttonRecycleView = findViewById(R.id.buttonGoToRecycleView);
    }

    @Override
    public void onDateSet(DatePicker view, int selectedYear,
                          int selectedMonth, int selectedDay) {
        edtDate.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                + selectedYear);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        edtTime.setText(hourOfDay + ":" + minute );
    }
}