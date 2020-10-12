package com.appsinventiv.mazad.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.SharedPrefs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
        fragment = new HomeFragment();
        loadFragment(fragment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initNavigationDrawer();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);

                    return true;
                case R.id.navigation_my_ads:
//                    fragment = new MyAdsFragment();
//                    loadFragment(fragment);
                    return true;

                case R.id.navigation_profile:
//                    fragment = new CommunityFragment();
//                    loadFragment(fragment);
                    return true;
                case R.id.navigation_settings:
//                    fragment = new SettingsFragment();
//                    loadFragment(fragment);
                    return true;
                case R.id.navigation_ssdfs:
//                    fragment = new SettingsFragment();
//                    loadFragment(fragment);
                    return true;

            }
            return false;
        }
    };

    public void loadHome() {
        fragment = new HomeFragment();
        loadFragment(fragment);
    }

    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void initNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
//        TextView navUsername = (TextView) headerView.findViewById(R.id.name_drawer);
//        TextView navSubtitle = (TextView) headerView.findViewById(R.id.phone_drawer);
//        if (SharedPrefs.getUser() == null) {
//            navSubtitle.setText("Welcome to Phone Mart");
//
//            navUsername.setText("Login or Signup");
//            navUsername.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    gotoLoginActivity(Constants.HOME_ACTIVITY);
//                }
//            });
//        } else {
//            navSubtitle.setText(SharedPrefs.getUser().getCity());
//
//            navUsername.setText(SharedPrefs.getUser().getName());
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//
//            return true;
//        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        }
        return false;
    }
}