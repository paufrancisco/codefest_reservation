package com.example.codefestsample;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.example.codefestsample.databinding.ActivityFarmerHomeBinding;
import com.example.codefestsample.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FarmerHome extends AppCompatActivity {

    ActivityFarmerHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_home);
        replaceFragment(new Frag_FarmerList());

        binding = ActivityFarmerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.bn_home){
                replaceFragment(new Frag_FarmerHome());
            } else if (item.getItemId() == R.id.bn_profile) {
                replaceFragment(new Frag_FarmerProfile());
            } else if (item.getItemId() == R.id.bn_list) {
                replaceFragment(new Frag_FarmerList());
            }
            return true;
        });
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}