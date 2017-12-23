package com.example.rjcar.driverapp;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class DriverHome extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button map = findViewById(R.id.Map);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);

        mToolbar = findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Redirecting Account",Toast.LENGTH_SHORT).show();
                Intent driverMap = new Intent(getApplicationContext(),DriverMap.class);
                startActivity(driverMap);
                finish();
            }
        });

        NavigationView nv = (NavigationView)findViewById(R.id.nav_menu);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case(R.id.nav_my_account):
                        Toast.makeText(getApplicationContext(),
                                "Redirecting Account",Toast.LENGTH_SHORT).show();
                        Intent myAccount = new Intent(getApplicationContext(),MyAccount.class);
                        startActivity(myAccount);
                        finish();
                        break;
                    case(R.id.nav_home):
                        Toast.makeText(getApplicationContext(),
                                "Redirecting Home",Toast.LENGTH_SHORT).show();
                        Intent homePage = new Intent(getApplicationContext(),DriverHome.class);
                        startActivity(homePage);
                        finish();
                        break;
                    case(R.id.nav_settings):
                        Toast.makeText(getApplicationContext(),
                                "Redirecting Settings",Toast.LENGTH_SHORT).show();
                        Intent settings = new Intent(getApplicationContext(), com.example.rjcar.driverapp.Settings.class);
                        startActivity(settings);
                        finish();
                        break;
                    case(R.id.nav_logout):
                        Toast.makeText(getApplicationContext(),
                                "Logging Out",Toast.LENGTH_SHORT).show();
                        finish();
                        System.exit(0);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

