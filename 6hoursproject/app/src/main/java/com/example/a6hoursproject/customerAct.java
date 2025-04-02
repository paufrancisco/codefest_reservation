package com.example.a6hoursproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.a6hoursproject.cusFragments.cHomeFrag;
import com.example.a6hoursproject.cusFragments.cListFrag;
import com.example.a6hoursproject.cusFragments.cProfFrag;
import com.example.a6hoursproject.databinding.ActivityCustomerBinding;

public class customerAct extends AppCompatActivity {

    ActivityCustomerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.btn_Home){
                replaceFragment(new cHomeFrag());
            }else if(item.getItemId() == R.id.btn_List){
                replaceFragment(new cListFrag());
            }else if(item.getItemId() == R.id.btn_Profile){
                replaceFragment(new cProfFrag());
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