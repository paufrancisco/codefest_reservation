package com.example.codefestwarrior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.example.codefestwarrior.databinding.ActivityFarmerBinding;

public class ACTIVITY_Farmer extends AppCompatActivity {

    ActivityFarmerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFarmerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setFragment(new FragmentFarmerList());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.btn_home){
                setFragment(new FragmentFarmerHome());
            }else if(item.getItemId() == R.id.btn_list){
                setFragment(new FragmentFarmerList());
            }else if(item.getItemId() == R.id.btn_profile){
                setFragment(new FragmentFarmerProfile());
            }
            return true;
        });

    }
    void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}