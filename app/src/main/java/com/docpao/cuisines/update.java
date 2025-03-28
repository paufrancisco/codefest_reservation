package com.docpao.cuisines;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.docpao.R;
import com.docpao.dbHelper;
import com.docpao.myReservation;

import java.util.Calendar;

public class update extends AppCompatActivity {

    EditText eResNameUpdate, eNumberOfPersonUpdate, eDateAndTimeUpdate;
    Button bUpdate, bBack;
    int MAX_NUMBER_PERSON = 8;

    String dateAndTimeChosenUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        String id = intent.getStringExtra("res_id");
        String name = intent.getStringExtra("res_name");
        String number_person = intent.getStringExtra("res_number_person");
        String date_reserved = intent.getStringExtra("res_date_reserved");



        eResNameUpdate = findViewById(R.id.eResNameUpdate);
        eNumberOfPersonUpdate = findViewById(R.id.eNumberOfPersonUpdate);
        eDateAndTimeUpdate = findViewById(R.id.eDateAndTimeUpdate);

        bUpdate = findViewById(R.id.bUpdate);
        bBack = findViewById(R.id.bBack);


        eResNameUpdate.setText(name);
        eNumberOfPersonUpdate.setText(number_person);
        eDateAndTimeUpdate.setText(date_reserved);



        eDateAndTimeUpdate.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {

                int hrs = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view1, hourOfDay, minute) -> {

                    String newDateChosen = year1 + "/"+(month1+1)+"/"+dayOfMonth+" "+hourOfDay+":"+minute;

                    eDateAndTimeUpdate.setText(newDateChosen);


                },hrs , min , true);

                timePickerDialog.show();


            },year, month , day);
            datePickerDialog.show();

        });


        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(update.this);

                String newName = eResNameUpdate.getText().toString().trim();
                String newNumberPerson = eNumberOfPersonUpdate.getText().toString().trim();
                String newDateReserved = eDateAndTimeUpdate.getText().toString().trim();

                int numberPerson = Integer.parseInt(newNumberPerson);

                if (numberPerson<8 && numberPerson>0){
                    dbHelper.edtRes(id,newName,newNumberPerson,newDateReserved);
                    startActivity(new Intent(update.this, myReservation.class));
                }else {
                    Toast.makeText(update.this, "Maximum Number of Person is 8 and above 0", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}