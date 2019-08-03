package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drivercab.R;

public class CarProfileActivity extends AppCompatActivity {
ConstraintLayout constraintdocument;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_profile);
        constraintdocument=findViewById(R.id.constraintdocument);

        constraintdocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CarProfileActivity.this,CarDocumentActivity.class);
                startActivity(intent);
            }
        });
    }
}
