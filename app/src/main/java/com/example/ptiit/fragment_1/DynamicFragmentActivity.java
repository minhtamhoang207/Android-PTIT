package com.example.ptiit.fragment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ptiit.R;

public class DynamicFragmentActivity extends AppCompatActivity implements
        View.OnClickListener {

    private Button btA, btB, btC, back;
    private Button rmA, rmB, rmC, pop;
    private FragmentManager manager;
    private FragmentTransaction transaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        btA = findViewById(R.id.bta);
        btB = findViewById(R.id.btb);
        btC = findViewById(R.id.btc);
        rmA = findViewById(R.id.btn_rma);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
        btC.setOnClickListener(this);
        rmA.setOnClickListener(this);
        manager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fg;
        switch (view.getId()) {
            case R.id.bta:
                addA(view);
                break;
            case R.id.btb:
                addB(view);
                break;
            case R.id.btc:
                addC(view);
                break;
            case R.id.btback:
            case R.id.btn_pop:
                onBackPressed();
                break;
            case R.id.btn_rma:
                popA(view);
                break;
            case R.id.btn_rmb:
                popB(view);
                break;
            case R.id.btn_rmc:
                popC(view);
                break;
        }
        transaction.commit();
    }

    private void add(Fragment fragment, String tag, String name) {
        transaction = manager.beginTransaction();
        transaction.add(R.id.layout, fragment, tag);
        transaction.addToBackStack(name);
        transaction.commit();
    }

    private void remove(Fragment fragment, String tag) {
        transaction = manager.beginTransaction();
//        fragment = manager.findFragmentByTag(tag);
        transaction.remove(fragment);
        transaction.commit();
    }

    public void addA(View v) {
        FragmentA fragment = new FragmentA();
        add(fragment, "fraga", "fa");
    }

    public void popA(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public void addB(View v) {
        FragmentB fragment = new FragmentB();
        add(fragment, "fragb", "fb");
    }

    public void popB(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public void addC(View v) {
        FragmentC fragment = new FragmentC();
        add(fragment, "fragc", "fc");

    }

    public void popC(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public void onBackPressed() {
        if (manager.getBackStackEntryCount() > 0)
            manager.popBackStack();
        else
            super.onBackPressed();
    }

}