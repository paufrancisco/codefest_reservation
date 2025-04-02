package com.example.a6hoursproject.farmFragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a6hoursproject.R;
import com.example.a6hoursproject.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class fListFrag extends Fragment {
    RecyclerView rcFarmer;
    adapter adapter;

    FloatingActionButton fab;
    boolean key;
    public fListFrag(boolean key) {
         this.key = key;
    }

    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String>NAME = new ArrayList<>();
    ArrayList<String>DES = new ArrayList<>();
    ArrayList<String>PRICE = new ArrayList<>();
    ArrayList<String>QTY = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_f_list, container, false);

        rcFarmer = view.findViewById(R.id.rcFarmer);
        fab = view.findViewById(R.id.fabAdd);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Add.class);
                startActivity(intent);
            }
        });






        storeInDataArray();
        adapter = new adapter(
                getContext(),
                ID,
                NAME,
                DES,
                PRICE,
                QTY
        );

        rcFarmer.setLayoutManager(new LinearLayoutManager(getContext()));
        rcFarmer.setAdapter(adapter);


        return view;
    }

    void storeInDataArray(){
        dbHelper db = new dbHelper(getContext());
        Cursor res = db.read();
        if (res.getCount()==0){
            Toast.makeText(getContext(), "Wala pang data par", Toast.LENGTH_SHORT).show();
        }else {
            while (res.moveToNext()){
                ID.add(res.getString(0));
                NAME.add(res.getString(1));
                DES.add(res.getString(2));
                PRICE.add(res.getString(3));
                QTY.add(res.getString(4));

            }
        }

    }
}