package com.example.ptiit.RecycleViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import com.example.ptiit.R;

import java.util.ArrayList;

public class RecycleViewAdapterActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_adapter);

        recyclerView = findViewById(R.id.recycle_view_1);

        ArrayList<Model1> courseModelArrayList = new ArrayList<Model1>();
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.trada));
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.img_test));
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.trada));
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.img_test));
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.trada));
        courseModelArrayList.add(new Model1("DSA in Java", "Content 1", R.drawable.img_test));

        Adapter1 courseAdapter = new Adapter1(courseModelArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);
    }

}