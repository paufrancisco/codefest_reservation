package com.example.codefestsample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Frag_FarmerHome extends Fragment {
    DBHelper dbHelper;
    EditText edtName, edtDesc, edtPrice, edtQuantity;
    Button submit;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag__farmer_home, container, false);
        // Declarations
        dbHelper = new DBHelper(getContext());
        edtName = view.findViewById(R.id.edt_ItemName);
        edtDesc = view.findViewById(R.id.edt_ItemDesc);
        edtPrice = view.findViewById(R.id.edt_ItemPrice);
        edtQuantity = view.findViewById(R.id.edt_ItemQuantity);
        submit = view.findViewById(R.id.btn_Submit);

        // Add item Button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.addItem(edtName.getText().toString(), edtDesc.getText().toString(), edtPrice.getText().toString(), edtQuantity.getText().toString());
                edtName.setText("");
                edtDesc.setText("");
                edtPrice.setText("");
                edtQuantity.setText("");
                FarmerHome activity = (FarmerHome) getActivity();
                activity.replaceFragment(new Frag_FarmerList());
            }
        });
        return view;
    }
}