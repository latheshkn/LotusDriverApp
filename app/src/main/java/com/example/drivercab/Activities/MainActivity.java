package com.example.drivercab.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.drivercab.DriverProfilemodel.Profile;
import com.example.drivercab.DriverProfilemodel.ProfileResponse;
import com.example.drivercab.DriverProfilemodel.ProfileaRecyclerAdapter;
import com.example.drivercab.Fragments.HomeFragment;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.drivercab.RegisterModel.Register;
import com.example.drivercab.RegisterModel.RegisterResponse;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView mobileNo,txtheadername;
    Fragment fragment;
    NavigationView navigationView;
    String Mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//     txttile = findViewById(R.id.txttile);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        View headerview = navigationView.getHeaderView(0);


//       Otp otp=SharedPrefManager.getInstance(MainActivity.this).getUser();
//      String  mob= otp.getMobile();


//
        getRecipe();


        fragment = new HomeFragment();
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.replace(R.id.replace, fragment);
        ts.commit();


        LinearLayout header = (LinearLayout) headerview.findViewById(R.id.linearheader);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DriverProfileActivity.class);
                startActivity(intent);


            }
        });


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();

        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

            Intent intent = new Intent(MainActivity.this, WorkDetailsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_tools) {
            Intent intent = new Intent(MainActivity.this, BalanceAndPaymentActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_support) {
            Intent intent = new Intent(MainActivity.this, Support.class);
            startActivity(intent);
        } else if (id == R.id.nav_shift) {
            Intent intent = new Intent(MainActivity.this, ShiftActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_message) {
            Intent intent = new Intent(MainActivity.this, NtificationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_About) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if (fragment != null) {
            FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
            ts.replace(R.id.replace, fragment);
            ts.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getRecipe() {

        //    Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));
        Otp otp=SharedPrefManager.getInstance(MainActivity.this).getUser();
        Mob=otp.getMobile();
        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<ProfileResponse> call = recipeHomeApi.getheader(Mob);

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()) {
                    ProfileResponse profileResponse = response.body();
                    List<Profile> profiles = profileResponse.getData();
                    View headerview = navigationView.getHeaderView(0);
                    mobileNo = headerview.findViewById(R.id.mobileNo);
                    txtheadername=headerview.findViewById(R.id.txtheadername);


                    for (Profile p : profiles) {
                        mobileNo.setText(p.getMobile());
                        txtheadername.setText(p.getName());
                        Toast.makeText(MainActivity.this, p.getMobile(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
