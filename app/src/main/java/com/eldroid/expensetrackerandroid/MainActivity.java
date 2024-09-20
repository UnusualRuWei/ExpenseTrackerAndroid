package com.eldroid.expensetrackerandroid;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.eldroid.expensetrackerandroid.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.layoutContent, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Apply padding only to the content view, not the whole layout
            v.setPadding(0, systemBars.top, 0, 0);
            return insets;
        });

        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigation, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, 0, 0, systemBars.bottom); // Apply bottom padding to accommodate navigation bar
            return insets;
        });

        SparseArray<Fragment> fragmentArray = new SparseArray<>();
        fragmentArray.put(R.id.nav_expense, new ExpenseFragment());
        fragmentArray.put(R.id.nav_profile, new ProfileFragment());
        fragmentArray.put(R.id.nav_settings, new SettingsFragment());

        FloatingActionButton fabNavHome = findViewById(R.id.fab_nav_home);

        binding.bottomNavView.setSelectedItemId(R.id.nav_home);

        fabNavHome.setOnClickListener(v -> {
            replaceFragment(new HomeFragment());
        });


        binding.bottomNavView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = fragmentArray.get(item.getItemId());
            if (fragment != null) {
                replaceFragment(fragment);
                return true;
            } else if (item.getItemId() == R.id.nav_logout) {
                showLogoutDialogueFragment();
                return true;
            }
            return false;
        });

        replaceFragment(new HomeFragment());

        binding.bottomNavView.setBackground(null);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }

    private void showLogoutDialogueFragment() {
        LogoutDialogueFragment dialogFragment = new LogoutDialogueFragment();

        dialogFragment.setLogoutDialogListener(() -> {

            finish();
        });

        dialogFragment.show(getSupportFragmentManager(), "LogoutDialogFragment");
    }
}