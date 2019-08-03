package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.drivercab.R;

public class EditBankDetailsActivity extends AppCompatActivity {
Toolbar toolbankdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bank_details);

        toolbankdetails=findViewById(R.id.toolbankdetails);
        setSupportActionBar(toolbankdetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
