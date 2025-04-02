package com.example.a6hoursproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    Context context;

    public adapter(
            Context context,
            ArrayList<String> ID,
            ArrayList<String> NAME,
            ArrayList<String> DES,
            ArrayList<String> PRICE,
            ArrayList<String> QTY) {
        this.context = context;
        this.ID = ID;
        this.NAME = NAME;
        this.DES = DES;
        this.PRICE = PRICE;
        this.QTY = QTY;
    }

    ArrayList<String>ID;
    ArrayList<String>NAME;
    ArrayList<String>DES;
    ArrayList<String>PRICE;
    ArrayList<String>QTY;

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {

        String getID = ID.get(position);
        String getName = NAME.get(position);
        String getDes = DES.get(position);
        String getPrice = PRICE.get(position);
        String getQty = QTY.get(position);

        holder.tID.setText(getID);
        holder.tName.setText(getName);
        holder.tDes.setText(getDes);
        holder.tPrice.setText(getPrice);
        holder.tQty.setText(getQty);

    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tID,tName, tDes, tPrice, tQty;
        ImageButton imgDelete;
        ImageView imgBuy;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tDes = itemView.findViewById(R.id.tDes);
            tPrice = itemView.findViewById(R.id.tPrice);
            tQty = itemView.findViewById(R.id.tQty);
            tID = itemView.findViewById(R.id.tID);

            imgDelete = itemView.findViewById(R.id.imgDelete);
            imgBuy = itemView.findViewById(R.id.imgBuy);

        }
    }
}

