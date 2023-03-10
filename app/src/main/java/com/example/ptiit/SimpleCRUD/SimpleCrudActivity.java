package com.example.ptiit.SimpleCRUD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ptiit.R;

import java.util.ArrayList;

public class SimpleCrudActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    Spinner spinner;
    String[] catType = {"Meo tam the","Meo muop","Meo tai cup","Meo sphynx"};
    int catImages[] = {R.drawable.meo_tam_the, R.drawable.meo_muop, R.drawable.tai_cup, R.drawable.sphynx};
    EditText edtCatName, edtCatPrice, edtDescribe;
    Button btnAdd, btnUpdate;
    RecyclerView recyclerView;
    String spinnerCatType = "";
    CatListAdapter catListAdapter;
    int spinnerCatImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_crud);
        initView();

        spinner.setOnItemSelectedListener(this);
        SpinnerAdapter customAdapter = new SpinnerAdapter(getApplicationContext(),catImages,catType);
        spinner.setAdapter(customAdapter);

        catListAdapter = new CatListAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(catListAdapter);

        btnAdd.setOnClickListener(view -> {
            try {
                String catName = edtCatName.getText().toString();
                double catPrice = Double.parseDouble(edtCatPrice.getText().toString());
                String catDescribe = edtDescribe.getText().toString();
                CatModel cat = new CatModel();
                cat.setName(catName);
                cat.setPrice(catPrice);
                cat.setDescription(catDescribe);
                cat.setType(spinnerCatType);
                cat.setImage(spinnerCatImage);

                catListAdapter.addCat(cat);
            } catch (Exception e){
                Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void initView(){
        spinner = findViewById(R.id.spinner_cat);
        edtCatName = findViewById(R.id.editTextCatName);
        edtCatPrice = findViewById(R.id.editTextCatPrice);
        edtDescribe = findViewById(R.id.editTextCatDescribe);
        btnAdd = findViewById(R.id.buttonAddCat);
        btnUpdate = findViewById(R.id.buttonUpdateCat);
        recyclerView = findViewById(R.id.cat_recycle_view);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        spinnerCatType = catType[position];
        spinnerCatImage = catImages[position];
        Toast.makeText(getApplicationContext(), catType[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}