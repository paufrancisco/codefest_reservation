package com.example.codefestsample;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Frag_FarmerList extends Fragment {

    RecyclerView rcView;
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String>Name = new ArrayList<>();
    ArrayList<String>Desc = new ArrayList<>();
    ArrayList<String>Price = new ArrayList<>();
    ArrayList<String>Quantity = new ArrayList<>();
    boolean key;

    public Frag_FarmerList(boolean key) {
        this.key = key;
    }

    public Frag_FarmerList( ) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_frag__farmer_list, container, false);

        rcView = rootView.findViewById(R.id.rcViewer);
        storeDataInArray();
        Adapter adapter = new Adapter(getContext(),
                ID,
                Name,
                Desc,
                Price,
                Quantity,
                key);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));
        rcView.setAdapter(adapter);
        return rootView;

    }
    public void storeDataInArray(){
        DBHelper dbHelper = new DBHelper(getContext());
        Cursor res = dbHelper.viewItems();

        if(res.getCount() == 0){
            Toast.makeText(getContext(), "No data yet", Toast.LENGTH_SHORT).show();
        }else{
            while(res.moveToNext()){
                ID.add(res.getString(0));
                Name.add(res.getString(1));
                Desc.add(res.getString(2));
                Price.add(res.getString(3));
                Quantity.add(res.getString(4));
            }
        }
    }
}