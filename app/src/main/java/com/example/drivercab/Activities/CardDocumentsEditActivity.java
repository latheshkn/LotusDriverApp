package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drivercab.R;

public class CardDocumentsEditActivity extends AppCompatActivity {
ConstraintLayout txtrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_documents_edit);
        txtrc=findViewById(R.id.txtrc);

        txtrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(CardDocumentsEditActivity.this,EditCardDocument.class);
                startActivity(intent);
            }
        });
    }
}
