package com.example.ptiit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEdt, passwordEdt;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginButton.setOnClickListener(view -> {
            String username = usernameEdt.getText().toString();
            String password = passwordEdt.getText().toString();
            System.out.println(username);
            System.out.println(password);
            if(username.equalsIgnoreCase("Tom") && password.equals("123456")){
                Intent myIntent = new Intent(this, CalculatorActivity.class);
                this.startActivity(myIntent);
            } else {
                Toast.makeText(this, "Sai thông tin đăng nhập", Toast.LENGTH_LONG).show();
            }
        });
    }

    void initView(){
        usernameEdt = findViewById(R.id.editTextTextEmailAddress);
        passwordEdt = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.login_button);
    }
}