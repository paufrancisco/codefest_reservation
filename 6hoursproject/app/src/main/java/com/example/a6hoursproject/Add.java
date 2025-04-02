package com.example.a6hoursproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Add extends AppCompatActivity {

    EditText eName, eDes, ePrice, eQty;
    Button bCancel, bConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        eName = findViewById(R.id.eName);
        eDes = findViewById(R.id.eDes);
        ePrice = findViewById(R.id.ePrice);
        eQty = findViewById(R.id.eQty);

        bCancel = findViewById(R.id.bCancel);
        bConfirm = findViewById(R.id.bConfirm);


       bConfirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String inputName = eName.getText().toString().trim();
               String inputDes = eDes.getText().toString().trim();
               String inputPrice = ePrice.getText().toString().trim();
               String inputQty = eQty.getText().toString().trim();

               dbHelper db = new dbHelper(Add.this);

               db.addRes(inputName,inputDes,inputPrice,inputQty);

               finish();

           }
       });

       bCancel.setOnClickListener(v->finish());

    }
}