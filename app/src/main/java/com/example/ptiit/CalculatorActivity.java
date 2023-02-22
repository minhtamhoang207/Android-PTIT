package com.example.ptiit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button buttonCalSum;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
        buttonCalSum.setOnClickListener(view -> {
            int sum = calSum(
                    Integer.parseInt(editText1.getText().toString()),
                    Integer.parseInt(editText2.getText().toString())
            );
            System.out.println(sum);
            result.setText(String.valueOf(sum));
        });

    }

    void init(){
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        buttonCalSum = findViewById(R.id.button_sum);
        result = findViewById(R.id.textViewResult);
    }

    int calSum(int a, int b){
        return a + b;
    }

}