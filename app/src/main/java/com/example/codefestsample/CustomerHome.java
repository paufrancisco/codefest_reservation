package com.example.codefestsample;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.codefestsample.databinding.ActivityCustomerHomeBinding;

public class CustomerHome extends AppCompatActivity {

    ActivityCustomerHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_home);

        binding = ActivityCustomerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent = getIntent();

        boolean key = intent.getBooleanExtra("customer",true);
        setFragment(new Frag_CustomerList(key));



        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.bn_home){
                setFragment(new Frag_CustomerHome());
            } else if (item.getItemId() == R.id.bn_list) {
                setFragment(new Frag_CustomerList(key));
            } else if (item.getItemId() == R.id.bn_profile) {
                setFragment(new Frag_CustomerProfile());
            }

            return true;
        });



    }
    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2, fragment);
        fragmentTransaction.commit();
    }
}