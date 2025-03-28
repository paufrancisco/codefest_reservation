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

public class french extends AppCompatActivity {


    Button fBack, bFrRes1,bFrRes2,bFrRes3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        fBack = findViewById(R.id.fBack);
        bFrRes1 = findViewById(R.id.bFrRes1);
        bFrRes2 = findViewById(R.id.bFrRes2);
        bFrRes3 = findViewById(R.id.bFrRes3);




        fBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bFrRes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(french.this, add.class);
                intent.putExtra("res_name","Fr Restaurant 1");
                startActivity(intent);
            }
        });
        bFrRes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(french.this, add.class);
                intent.putExtra("res_name","Fr Restaurant 2");
                startActivity(intent);
            }
        });
        bFrRes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(french.this, add.class);
                intent.putExtra("res_name","Fr Restaurant 3");
                startActivity(intent);
            }
        });



    }
}