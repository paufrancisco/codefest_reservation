package com.example.a6hoursproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.a6hoursproject.databinding.ActivityFarmerBinding;
import com.example.a6hoursproject.farmFragments.fHomeFrag;
import com.example.a6hoursproject.farmFragments.fListFrag;
import com.example.a6hoursproject.farmFragments.fProfFrag;

public class farmerAct extends AppCompatActivity {
    ActivityFarmerBinding binding;
    boolean key = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate layout and check for null
        binding = ActivityFarmerBinding.inflate(getLayoutInflater());
        if (binding == null) {
            Log.e("farmerAct", "Binding is null! Check activity_farmer.xml");
            finish(); // Close activity if binding fails
            return;
        }
        setContentView(binding.getRoot());

        // Check if bottomNav exists
        if (binding.bottomNav == null) {
            Log.e("farmerAct", "bottomNav is null! Check activity_farmer.xml");
            return;
        }

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.btn_Home:
                    replaceFragment(new fHomeFrag());
                    break;
                case R.id.btn_List:
                    replaceFragment(new fListFrag(key));
                    break;
                case R.id.btn_Profile:
                    replaceFragment(new fProfFrag());
                    break;
            }
            return true;
        });

        // Load the default fragment
        replaceFragment(new fListFrag(key));
    }

    void replaceFragment(Fragment fragment) {
        if (isFinishing() || isDestroyed()) {
            Log.e("farmerAct", "Cannot replace fragment, Activity is finishing or destroyed.");
            return;
        }

        // Check if frameLayout exists
        if (findViewById(R.id.frameLayout) == null) {
            Log.e("farmerAct", "frameLayout is missing! Check activity_farmer.xml");
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
