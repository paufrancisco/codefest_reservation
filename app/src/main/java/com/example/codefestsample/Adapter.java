package com.example.codefestsample;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
                   ArrayList<String> quantity,
                   boolean key) {
        this.context = context;
        this.ID = ID;
        this.Name = name;
        this.Desc = desc;
        this.Price = price;
        this.Quantity = quantity;
        this.key = key;
        dbHelper = new DBHelper(context);

    }
    boolean key;
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

        if (key){
            holder.delete_button.setVisibility(INVISIBLE);
        }else {
            holder.delete_button.setVisibility(VISIBLE);
        }
        // Delete button
        holder.delete_button.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Delete confirmation");
            builder.setMessage("Are you sure you want to delete?");
            builder.setPositiveButton("Yes", (dialog, which) -> {
                String itemID = ID.get(position);
                dbHelper.deleteItem(itemID);
                ID.remove(position);
                Name.remove(position);
                Desc.remove(position);
                Price.remove(position);
                Quantity.remove(position);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, ID.size());
            });
            builder.setNegativeButton("No", (dialog, which) -> {
               dialog.dismiss();
            });
            builder.create().show();
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("id",ID.get(position));
                intent.putExtra("name",Name.get(position));
                intent.putExtra("des",Desc.get(position));
                intent.putExtra("price",Price.get(position));
                intent.putExtra("qty",Quantity.get(position));

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_ID, txt_Name, txt_Desc, txt_Price, txt_Quantity;
        Button delete_button;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_ID = itemView.findViewById(R.id.txt_ID);
            txt_Name = itemView.findViewById(R.id.txt_Name);
            txt_Desc = itemView.findViewById(R.id.txt_Desc);
            txt_Price = itemView.findViewById(R.id.txt_Price);
            txt_Quantity = itemView.findViewById(R.id.txt_Quantity);
            delete_button = itemView.findViewById(R.id.button_del);

            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
