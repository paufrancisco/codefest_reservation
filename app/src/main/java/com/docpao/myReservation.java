package com.docpao;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class myReservation extends AppCompatActivity {

    RecyclerView rcReservation;
    FloatingActionButton bCustomerHomePage;
    TextView tTotalNoOfPerson;

    resAdapter adapter;
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> NAME = new ArrayList<>();
    ArrayList<String> NO_OF_PERSON = new ArrayList<>();
    ArrayList<String> DATE_RESERVED = new ArrayList<>();
    ArrayList<String> DATE_SENT = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservation);


        rcReservation = findViewById(R.id.rcReservation);
        bCustomerHomePage  = findViewById(R.id.bCustomerHomePage);
        tTotalNoOfPerson = findViewById(R.id.tTotalNoOfPerson);

        storeInArray();
        adapter = new resAdapter(this,
                ID,
                NAME,
                NO_OF_PERSON,
                DATE_RESERVED,
                DATE_SENT
                );


        rcReservation.setLayoutManager(new LinearLayoutManager(this));
        rcReservation.setAdapter(adapter);

        dbHelper dbHelper = new dbHelper(this);
        int mema = dbHelper.sumOfColumnNoOfPerson();

        tTotalNoOfPerson.setText(String.valueOf(mema));

        tTotalNoOfPerson.setVisibility(View.INVISIBLE);





        bCustomerHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myReservation.this, customer_homepage.class));
            }
        });
    }

    void storeInArray(){
        dbHelper dbHelper = new dbHelper(this);
        Cursor res = dbHelper.read();

        if (res.getCount()==0){
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }else {
            while (res.moveToNext()){
                ID.add(res.getString(0));
                NAME.add(res.getString(1));
                NO_OF_PERSON.add(res.getString(2));
                DATE_RESERVED.add(res.getString(3));
                DATE_SENT.add(res.getString(4));


            }
        }

    }








}