package com.docpao;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class add extends AppCompatActivity {

    EditText eResName, eNumberOfPerson, eDateAndTime;
    Button bSubmit, bBack;
    int MAX_NUMBER_PERSON = 8;

    String dateAndTimeChosen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        eResName = findViewById(R.id.eResName);
        eNumberOfPerson = findViewById(R.id.eNumberOfPerson);
        eDateAndTime = findViewById(R.id.eDateAndTime);

        bSubmit = findViewById(R.id.bSubmit);
        bBack = findViewById(R.id.bBack);


        Intent intent = getIntent();

        String getResName = intent.getStringExtra("res_name");

        eResName.setText(getResName);



//        eDateAndTime.setOnClickListener(v -> {
//            Calendar calendar = Calendar.getInstance();
//            int year = calendar.get(Calendar.YEAR);
//            int month = calendar.get(Calendar.MONTH);
//            int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(this,(view, year1, month1, dayOfMonth) -> {
//
//            int hrs = calendar.get(Calendar.HOUR_OF_DAY);
//            int min = calendar.get(Calendar.HOUR_OF_DAY);
//
//            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view1, hourOfDay, minute) -> {
//
//            String dateAndTimeChosen = year1+ " / "+(month1+1)+" / "+dayOfMonth+" "+hourOfDay+":"+minute;
//
//            eDateAndTime.setText(dateAndTimeChosen);
//
//            },hrs,min,true);
//            timePickerDialog.show();
//
//            }, year , month , day);
//            datePickerDialog.show();
//        });




            eDateAndTime.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view1, hourOfDay, minute) -> {

            dateAndTimeChosen = year1 + "/" + (month1+1)+"/"+dayOfMonth + " "+hourOfDay+":"+minute;

            eDateAndTime.setText(dateAndTimeChosen);
            }, hour , min , true);
            timePickerDialog.show();
            }, year , month , day);
            datePickerDialog.show();
            });


            bSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dbHelper db = new dbHelper(add.this);

                    String resName = eResName.getText().toString().trim();
                    String resNumberOfPerson = eNumberOfPerson.getText().toString().trim();
                    int resIntNumberOfPerson = Integer.parseInt(resNumberOfPerson);
                    String edateAndTimeChosen = eDateAndTime.getText().toString().trim();

                    if (isValid(resIntNumberOfPerson)){
                        db.addRes(resName,resNumberOfPerson,edateAndTimeChosen);
                        startActivity(new Intent(add.this, myReservation.class));
                    }


                }
            });

            bBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });



    }


    public boolean isValid(int inputPerson){
        if (inputPerson<=MAX_NUMBER_PERSON && inputPerson>0) {
            return true;
        }else {
            Toast.makeText(this, "Tol dapat below 8 or exactly 8", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}