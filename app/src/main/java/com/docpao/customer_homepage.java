package com.docpao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.docpao.cuisines.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.docpao.cuisines.chinese;

import java.util.Calendar;

public class customer_homepage extends AppCompatActivity {

    Button bChinese,bFilipino,bFrench,bGoToRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_homepage);

        bChinese = findViewById(R.id.bChinese);
        bFilipino = findViewById(R.id.bFilipino);
        bFrench = findViewById(R.id.bFrench);
        bGoToRes = findViewById(R.id.bGoToRes);


        bChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customer_homepage.this, chinese.class));
            }
        });
        bFilipino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customer_homepage.this, filipino.class));
            }
        });
        bFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customer_homepage.this, french.class));
            }
        });

        bGoToRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hrs = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                if (hrs>=8 && hrs <= 20){
                    if (min > 0 && min < 30){
                        startActivity(new Intent(customer_homepage.this, myReservation.class));
                    }
                    else {
                        Toast.makeText(customer_homepage.this, "Reservation is not allowed", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(customer_homepage.this, "Reservation is not allowed", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}