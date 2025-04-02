package com.example.codefestsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button farmer_login;
    EditText edtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        farmer_login = findViewById(R.id.btn_farmerLogin);
        edtMail = findViewById(R.id.edt_Mail);

        farmer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtMail.getText().toString().equals("Hello")){
                    Intent intent = new Intent(MainActivity.this, FarmerHome.class);
                    intent.putExtra("farmer",false);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MainActivity.this, CustomerHome.class);
                    intent.putExtra("customer",true);
                    startActivity(intent);
                }

            }
        });

    }
}