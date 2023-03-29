package com.example.ptiit.RecycleViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptiit.R;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {

    private final ArrayList<Model1> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardItem;
        TextView title;
        TextView content;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardItem = (CardView) itemView.findViewById(R.id.card_item_1);
            this.title = (TextView) itemView.findViewById(R.id.title_1);
            this.content = (TextView) itemView.findViewById(R.id.content_1);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.img_item_1);
        }
    }

    public Adapter1(ArrayList<Model1> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_1, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int index) {

        TextView textViewName = holder.title;
        TextView textViewVersion = holder.content;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(index).getTitle());
        textViewVersion.setText(dataSet.get(index).getContent());
        imageView.setImageResource(dataSet.get(index).getImage());

        holder.cardItem.setOnClickListener(view -> {
            Toast.makeText(holder.cardItem.getContext(),
                    dataSet.get(index).getTitle() + dataSet.get(index).getContent() ,
                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
