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
        courseModelArrayList.add(new Model1("Android", "Content 1", R.drawable.trada, "Subtitle 1"));
        courseModelArrayList.add(new Model1("IOS", "Content 2", R.drawable.meo_tam_the, "Subtitle 2"));
        courseModelArrayList.add(new Model1("Black berry", "Content 3", R.drawable.meo_muop, "Subtitle 3"));
        courseModelArrayList.add(new Model1("Window", "Content 4", R.drawable.meo_ba_tu, "Subtitle 4"));
        courseModelArrayList.add(new Model1("ABC xyz", "Content 5", R.drawable.sphynx, "Subtitle 5"));
        courseModelArrayList.add(new Model1("hsjadhaksj", "Content 6", R.drawable.img_test, "Subtitle 6"));

        Adapter1 courseAdapter = new Adapter1(courseModelArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);
    }

}