package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.drivercab.R;

public class SettingActivity extends AppCompatActivity {
ConstraintLayout language;
Switch seekbardriverlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        seekbardriverlogin=findViewById(R.id.seekbardriverlogin);
        seekbardriverlogin.setChecked(true);

        seekbardriverlogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Logout();
            }
        });



    }

    private void Logout(){
        //here we are calling logOut Method from SharedPrefrence
        SharedPrefManager.getInstance(SettingActivity.this).logOut();
        Toast.makeText(this, "Signout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SettingActivity.this,SignInActivity.class);
        startActivity(intent);
        finish();
    }



}
