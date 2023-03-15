package com.example.ptiit.SimpleCRUD;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptiit.R;
import com.example.ptiit.SimpleCRUD.CatModel;

import java.util.ArrayList;
import java.util.List;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.MyViewHolder> {

    private List<CatModel> dataSet;
    int currentCat;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardItem;
        TextView name, price, description;
        ImageView catImage;
        ImageButton buttonDeleteCat, btnUpdateCat;
        EditText edtCatName, edtCatPrice, edtDescribe;
        Spinner spinner;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardItem = (CardView) itemView.findViewById(R.id.cat_card);
            this.name = (TextView) itemView.findViewById(R.id.cat_name_item);
            this.price = (TextView) itemView.findViewById(R.id.cat_price_item);
            this.description = (TextView) itemView.findViewById(R.id.cat_describe_item);
            this.catImage = (ImageView) itemView.findViewById(R.id.cat_card_img);
            this.buttonDeleteCat = itemView.findViewById(R.id.buttonDeleteCat);
            this.btnUpdateCat = itemView.findViewById(R.id.btnUpdateCat);

            this.spinner = itemView.findViewById(R.id.spinner_cat);
            this.edtCatName = itemView.findViewById(R.id.editTextCatName);
            this.edtCatPrice = itemView.findViewById(R.id.editTextCatPrice);
            this.edtDescribe = itemView.findViewById(R.id.editTextCatDescribe);
        }
    }

    public CatListAdapter() {
        dataSet = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int index) {

        holder.name.setText(dataSet.get(index).getName());
        holder.price.setText(String.valueOf(dataSet.get(index).getPrice()));
        holder.description.setText(dataSet.get(index).getDescription());
        holder.catImage.setImageResource(dataSet.get(index).getImage());

        holder.cardItem.setOnClickListener(view -> {
            Toast.makeText(holder.cardItem.getContext(),
                    "updating :" + dataSet.get(index).getName(),
                    Toast.LENGTH_SHORT).show();
        });

        holder.btnUpdateCat.setOnClickListener(view -> {
            int currentCat = index;
        });

        holder.buttonDeleteCat.setOnClickListener(view -> {
            dataSet.remove(index);
            notifyItemRemoved( index );
            notifyItemRangeChanged(index, dataSet.size());
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    void addCat(CatModel cat){
        dataSet.add(cat);
        notifyDataSetChanged();
    }

    void searchCat(String catName){
        List<CatModel> newCat = new ArrayList<>();
        for(CatModel element : dataSet){
            if(element.name.toLowerCase().contains(catName.toLowerCase())){
                newCat.add(element);
            }
        }
        dataSet = newCat;
        notifyDataSetChanged();
    }

    void updateCat(CatModel cat){
        dataSet.set(currentCat, cat);
        notifyDataSetChanged();
    }
}
