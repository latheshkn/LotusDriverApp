package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drivercab.R;

public class WorkDetailsActivity extends AppCompatActivity {
ConstraintLayout txtrc,txtpermit,conpuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details);

        txtrc=findViewById(R.id.txtrc);
        txtpermit=findViewById(R.id.txtpermit);
        conpuc=findViewById(R.id.conpuc);


        conpuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WorkDetailsActivity.this,BookingDetails.class);
                startActivity(intent);
            }
        });
        txtpermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WorkDetailsActivity.this,BalanceAndPaymentActivity.class);
                startActivity(intent);
            }
        });
        txtrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WorkDetailsActivity.this,VehicleOnRoad.class);
                startActivity(intent);
            }
        });
    }
}
