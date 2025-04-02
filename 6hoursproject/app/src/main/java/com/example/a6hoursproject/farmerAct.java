package com.example.a6hoursproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.a6hoursproject.databinding.ActivityFarmerBinding;

public class farmerAct extends AppCompatActivity {
    ActivityFarmerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFarmerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new fListFrag());

        binding.bottomNav.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.btn_Home){
                replaceFragment(new fHomeFrag());
            }else if(item.getItemId() == R.id.btn_List){
                replaceFragment(new fListFrag());
            }else if(item.getItemId() == R.id.btn_Profile){
                replaceFragment(new fProfFrag());
            }

            return true;
        });

    }
    void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}