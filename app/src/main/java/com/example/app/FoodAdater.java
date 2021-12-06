package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdater extends  RecyclerView.Adapter<FoodAdater.FoodViewHolder>{

    private List<Food_Infor> mListFood;

    public FoodAdater(List<Food_Infor> mListFood) {
        this.mListFood = mListFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfood,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food_Infor food = mListFood.get(position);
        if(food == null){
            return;
        }
        holder.tvName.setText("Name: "+food.getName());
        holder.tvPrice.setText("Price: "+food.getPrice());
        Picasso.get().load(food.getImg()).into(holder.Imgv);
    }

    @Override
    public int getItemCount() {
        if(mListFood != null) {
            return mListFood.size();
        }
        return 0;
    }

    public  class FoodViewHolder extends RecyclerView.ViewHolder{
        //private TextView tvId;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvImg;
        private ImageView Imgv;
        private CheckBox cb;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            //tvId = itemView.findViewById(R.id.tvID);
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvImg=itemView.findViewById(R.id.tvimg);
            Imgv=itemView.findViewById(R.id.imgv);
            cb=itemView.findViewById(R.id.cb);
        }
    }
}
