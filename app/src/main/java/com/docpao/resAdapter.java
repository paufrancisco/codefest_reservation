package com.docpao;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.docpao.cuisines.update;

import java.util.ArrayList;

public class resAdapter extends RecyclerView.Adapter<resAdapter.resViewHolder> {

    ArrayList<String> ID;
    ArrayList<String> NAME;
    ArrayList<String> NO_OF_PERSON;
    ArrayList<String> DATE_RESERVED;
    ArrayList<String> DATE_SENT;
    private Context context;

    public resAdapter(Context context, ArrayList<String> ID, ArrayList<String> NAME, ArrayList<String> NO_OF_PERSON, ArrayList<String> DATE_RESERVED, ArrayList<String> DATE_SENT)
    {
        this.context = context;
        this.ID = ID;
        this.NAME = NAME;
        this.NO_OF_PERSON = NO_OF_PERSON;
        this.DATE_RESERVED = DATE_RESERVED;
        this.DATE_SENT = DATE_SENT;
    }



    @NonNull
    @Override
    public resAdapter.resViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardviewer,parent,false);
        return new resViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull resAdapter.resViewHolder holder, int position) {

        holder.tID.setText(ID.get(position));
        holder.tResName.setText(NAME.get(position));
        holder.tNumberOfPerson.setText(NO_OF_PERSON.get(position));
        holder.tDateReserved.setText(DATE_RESERVED.get(position));
        holder.tDateSent.setText(DATE_SENT.get(position));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Delete Confirmation");
                builder.setMessage("Are you sure you want to delete?"+NAME.get(position));
                builder.setPositiveButton("Yes",(dialog, which) -> {

                   dbHelper dbHelper = new dbHelper(context);

                   dbHelper.delRes(ID.get(position));

                   ID.remove(position);
                   NAME.remove(position);
                   NO_OF_PERSON.remove(position);
                   DATE_RESERVED.remove(position);
                   DATE_SENT.remove(position);

                   notifyItemRemoved(position);
                   notifyItemRangeChanged(position,ID.size());

                   dialog.dismiss();

                });

                builder.setNegativeButton("No",(dialog, which) -> {
                    dialog.dismiss();
                });

                builder.show();




            }
        });


        holder.cvRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(new Intent(context, update.class));
                intent.putExtra("res_id",ID.get(position));
                intent.putExtra("res_name",NAME.get(position));
                intent.putExtra("res_number_person",NO_OF_PERSON.get(position));
                intent.putExtra("res_date_reserved",DATE_RESERVED.get(position));

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class resViewHolder extends RecyclerView.ViewHolder {

    TextView tID, tResName, tNumberOfPerson, tDateReserved, tDateSent;
    ImageView delete;
    CardView cvRes;


        public resViewHolder(@NonNull View itemView) {
            super(itemView);

            tID = itemView.findViewById(R.id.tID);
            tResName = itemView.findViewById(R.id.tResName);
            tNumberOfPerson = itemView.findViewById(R.id.tNumberOfPerson);
            tDateReserved = itemView.findViewById(R.id.tDateReserved);
            tDateSent = itemView.findViewById(R.id.tDateSent);

            delete = itemView.findViewById(R.id.bRemove);

            cvRes = itemView.findViewById(R.id.cvRes);


        }
    }
}
