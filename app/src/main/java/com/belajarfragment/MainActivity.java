package com.belajarfragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int MENU_HOME = R.id.fr_home;
    private static final int MENU_DASHBOARD = R.id.fr_dashboard;
    private static final int MENU_NOTIFICATION = R.id.fr_notification;
    private static final int MENU_ACCOUNT = R.id.fr_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        int itemId = item.getItemId();
        if (itemId == MENU_HOME) {
            fragment = new HomeFragment();
        } else if (itemId == MENU_DASHBOARD) {
            fragment = new DashboardFragment();
        } else if (itemId == MENU_NOTIFICATION) {
            fragment = new NotificationFragment();
        } else if (itemId == MENU_ACCOUNT) {
            fragment = new AccountFragment();
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
