package com.mosambitech.pucresults;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.pushbots.push.Pushbots;

public class LaunchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    View cet, sslc, puc, comedk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Pushbots.sharedInstance().init(this);
        TypefaceProvider.registerDefaultIconSets();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sslc = (View) findViewById(R.id.btn_sslc);
        cet = (View) findViewById(R.id.btn_cet);
        puc = (View) findViewById(R.id.btn_puc);
        comedk = (View) findViewById(R.id.btn_comedk);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sslc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LaunchActivity.this, ResultActivity.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                i.putExtra("LANG_TAG", "SSLC");
                startActivity(i);
            }
        });
        puc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LaunchActivity.this, ResultActivity.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                i.putExtra("LANG_TAG", "PUC");
                startActivity(i);
            }
        });
        cet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LaunchActivity.this, ResultActivity.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                i.putExtra("LANG_TAG", "CET");
                startActivity(i);
            }
        });
        comedk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LaunchActivity.this, ResultActivity.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                i.putExtra("LANG_TAG", "COMED K");
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cet) {
            // CET key Answers
            Toast.makeText(getApplicationContext(), "CET Key Answers Not Yet Announced", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_comedk) {
            // Comed K Key Answers
            Toast.makeText(getApplicationContext(), "COMED K Key Answers Not Yet Announced", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_colg_list) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
