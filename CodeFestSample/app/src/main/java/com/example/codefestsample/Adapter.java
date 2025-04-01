package com.example.codefestsample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    DBHelper dbHelper;
    public Adapter(Context context,
                   ArrayList<String> ID,
                   ArrayList<String> name,
                   ArrayList<String> desc,
                   ArrayList<String> price,
                   ArrayList<String> quantity) {
        this.context = context;
        this.ID = ID;
        this.Name = name;
        this.Desc = desc;
        this.Price = price;
        this.Quantity = quantity;
        dbHelper = new DBHelper(context);

    }

    ArrayList<String>ID;
    ArrayList<String>Name;
    ArrayList<String>Desc;
    ArrayList<String>Price;
    ArrayList<String>Quantity;

    Context context;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.txt_ID.setText(ID.get(position));
        holder.txt_Name.setText(Name.get(position));
        holder.txt_Desc.setText(Desc.get(position));
        holder.txt_Price.setText(Price.get(position));
        holder.txt_Quantity.setText(Quantity.get(position));


        // Delete button
        holder.delete_button.setOnClickListener(view -> {
            String itemID = ID.get(position);
            dbHelper.deleteItem(itemID);
            notifyItemChanged(position, getItemCount());
        });


    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_ID, txt_Name, txt_Desc, txt_Price, txt_Quantity;
        Button delete_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_ID = itemView.findViewById(R.id.txt_ID);
            txt_Name = itemView.findViewById(R.id.txt_Name);
            txt_Desc = itemView.findViewById(R.id.txt_Desc);
            txt_Price = itemView.findViewById(R.id.txt_Price);
            txt_Quantity = itemView.findViewById(R.id.txt_Quantity);
            delete_button = itemView.findViewById(R.id.button_del);

        }
    }
}
