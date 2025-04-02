package com.example.codefestwarrior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_FarmerLogin, btn_CustomerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // INSTANTIATIONS
        btn_FarmerLogin = findViewById(R.id.btn_FarmerLogin);
        btn_CustomerLogin = findViewById(R.id.btn_CustomerLogin);

        // FARMER BUTTON HANDLER
        btn_FarmerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY_Farmer.class);
                startActivity(intent);
            }
        });
        // CUSTOMER BUTTON HANDLER
        btn_CustomerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY_Customer.class);
                startActivity(intent);
            }
        });
    }
}