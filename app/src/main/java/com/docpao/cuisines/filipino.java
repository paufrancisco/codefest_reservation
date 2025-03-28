package com.docpao.cuisines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.docpao.R;
import com.docpao.add;

public class filipino extends AppCompatActivity {

    Button bF_Restaurant1, bF_Restaurant2, bF_Restaurant3,filipinoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filipino);

        bF_Restaurant1 = findViewById(R.id.bF_Restaurant1);
        bF_Restaurant2 = findViewById(R.id.bF_Restaurant2);
        bF_Restaurant3 = findViewById(R.id.bF_Restaurant3);
        filipinoBack = findViewById(R.id.filipinoBack);

        bF_Restaurant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(filipino.this, add.class);
                intent.putExtra("res_name","F Restaurant 1");
                startActivity(intent);
            }
        });
        bF_Restaurant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(filipino.this, add.class);
                intent.putExtra("res_name","F Restaurant 2");
                startActivity(intent);
            }
        });
        bF_Restaurant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(filipino.this, add.class);
                intent.putExtra("res_name","F Restaurant 3");
                startActivity(intent);
            }
        });

        filipinoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}