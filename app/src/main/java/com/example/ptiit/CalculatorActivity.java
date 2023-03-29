package com.example.ptiit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editText1, editText2;
    Button buttonCalSum;
    TextView result;
    Spinner spinner;
    String spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
        buttonCalSum.setOnClickListener(view -> {
            try {
                int sum = calculate(
                        Integer.parseInt(editText1.getText().toString()),
                        Integer.parseInt(editText2.getText().toString())
                );
                System.out.println(sum);
                result.setText(String.valueOf(sum));
                Toast.makeText(this, "Result is: " + sum, Toast.LENGTH_LONG).show();

            } catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.math, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    void init(){
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        buttonCalSum = findViewById(R.id.button_sum);
        result = findViewById(R.id.textViewResult);
        spinner = findViewById(R.id.spinner);
    }

    int calculate(int a, int b){
        switch (spinnerValue){
            case "-": return a - b;
            case "x": return a * b;
            case ":": return a / b;
            case "+":
            default: return a + b;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println(i);
        switch (i){
            case 1:
                spinnerValue = "-";
                break;
            case 2:
                spinnerValue = "x";
                break;
            case 3:
                spinnerValue = ":";
                break;
            default:
                spinnerValue = "+";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinnerValue = "+";
    }
}