package com.example.a6hoursproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_fLogin, btn_cLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INSTANTIATIONS
        btn_fLogin = findViewById(R.id.btn_FarmerLogin);
        btn_cLogin = findViewById(R.id.btn_CustomerLogin);

        // FARMER LOGIN HANDLER
        btn_fLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, farmerAct.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Signed in as a Farmer", Toast.LENGTH_SHORT).show();
            }
        });

        btn_cLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, customerAct.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Signed in as a Customer", Toast.LENGTH_SHORT).show();
            }
        });

    }
}