package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drivercab.R;

public class EditdriverDocuments extends AppCompatActivity {
 ConstraintLayout txtrc,txtpermit,conpuc,badge,Conadar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdriver_documents);
        txtrc=findViewById(R.id.txtrc);
        txtpermit=findViewById(R.id.txtpermit);
        conpuc=findViewById(R.id.conpuc);
        badge=findViewById(R.id.badge);
        Conadar=findViewById(R.id.Conadar);

        Conadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditdriverDocuments.this,EditAdhaaraNumberActivity.class);
                startActivity(intent);
            }
        });




        badge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditdriverDocuments.this,EditBadgeActivity.class);
                startActivity(intent);
            }
        });


        conpuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditdriverDocuments.this,EditNameActivity.class);
                startActivity(intent);
            }
        });


        txtpermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditdriverDocuments.this,EditLicenseActivity.class);
                startActivity(intent);
            }
        });
        txtrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditdriverDocuments.this,EditNumber.class);
                startActivity(intent);
            }
        });
    }
}
