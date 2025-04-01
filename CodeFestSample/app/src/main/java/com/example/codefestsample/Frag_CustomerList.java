package com.example.codefestsample;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
public class Frag_CustomerList extends Fragment {
    DBHelper dbHelper;
    RecyclerView recyclerView;

    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String>Name = new ArrayList<>();
    ArrayList<String>Desc = new ArrayList<>();
    ArrayList<String>Price = new ArrayList<>();
    ArrayList<String>Quantity = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag__customer_list, container, false);
        recyclerView = view.findViewById(R.id.rcviewCustomer);
        storeDataInArray();
        Adapter adapter = new Adapter(getContext(), ID, Name, Desc, Price, Quantity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void storeDataInArray(){
        dbHelper = new DBHelper(getContext());
        Cursor res = dbHelper.viewItems();

        if(res.getCount()==0){
            Toast.makeText(getContext(), "Found none", Toast.LENGTH_SHORT).show();
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



