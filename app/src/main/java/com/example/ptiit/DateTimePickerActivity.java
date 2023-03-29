package com.example.ptiit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ptiit.recycle_view_example.RecycleViewAdapterActivity;

public class DateTimePickerActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    EditText edtDate, edtTime;
    Button buttonDate, buttonTime, buttonRecycleView, bt;
    boolean is24HView = true;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        initView();
        registerForContextMenu(bt);
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
        tv=findViewById(R.id.tv);
        bt=findViewById(R.id.bt);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mFile:
                Toast.makeText(this,"Selected File",
                        Toast.LENGTH_LONG).show();

                break;
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mEmail:
                Toast.makeText(this,"Seelected Email",
                        Toast.LENGTH_LONG).show();

                break;
            case R.id.mPhone:
                Toast.makeText(this,"Selected phone",
                        Toast.LENGTH_LONG).show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mycontextmenu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mRed:
                tv.setTextColor(getResources().getColor(R.color.red));
                break;
            case R.id.mGreen:
                tv.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.mBlue:
                tv.setTextColor(getResources().getColor(R.color.blue));
                break;
        }
        return super.onContextItemSelected(item);
    }

}