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

public class chinese extends AppCompatActivity {

    Button cBack, bChineseRes1,bChineseRes2,bChineseRes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);


        cBack = findViewById(R.id.cBack);
        bChineseRes1 = findViewById(R.id.bChineseRes1);
        bChineseRes2 = findViewById(R.id.bChineseRes2);
        bChineseRes3 = findViewById(R.id.bChineseRes3);


        cBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bChineseRes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chinese.this, add.class);
                intent.putExtra("res_name","C Restaurant 1");
                startActivity(intent);
            }
        });
        bChineseRes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chinese.this, add.class);
                intent.putExtra("res_name","C Restaurant 2");
                startActivity(intent);
            }
        });
        bChineseRes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chinese.this, add.class);
                intent.putExtra("res_name","C Restaurant 3");
                startActivity(intent);
            }
        });





    }
}