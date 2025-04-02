package com.example.codefestsample;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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

public class Update extends AppCompatActivity {

    TextView uName;
    EditText uDes,uPrice,uQty;
    Button uCancel,uSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        uName = findViewById(R.id.uName);
        uDes = findViewById(R.id.uDes);
        uPrice = findViewById(R.id.uPrice);
        uQty = findViewById(R.id.uQty);

        uCancel = findViewById(R.id.uCancel);
        uSubmit = findViewById(R.id.uSubmit);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String des = intent.getStringExtra("des");
        String price = intent.getStringExtra("price");
        String qty = intent.getStringExtra("qty");


        uName.setText(name);
        uDes.setText(des);
        uPrice.setText(price);
        uQty.setText(qty);


        uCancel.setOnClickListener(v->finish());
        uSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(Update.this);

                String newDes = uDes.getText().toString();
                String newPrice = uPrice.getText().toString();
                String newQty = uQty.getText().toString();
                //void editItem(String id, String name, String Desc, String Price, String Quantity)
                db.editItem(id,name,newDes,newPrice,newQty);
                startActivity(new Intent(Update.this, FarmerHome.class));
                finish();

            }
        });

    }
}