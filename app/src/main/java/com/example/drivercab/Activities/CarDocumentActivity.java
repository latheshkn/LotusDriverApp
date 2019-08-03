package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.example.drivercab.R;

public class CarDocumentActivity extends AppCompatActivity {
ImageView imgdl;
TextView txtedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_document);
        imgdl=findViewById(R.id.imgdl);
        txtedit=findViewById(R.id.txtedit);

        txtedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CarDocumentActivity.this,CardDocumentsEditActivity.class);
                startActivity(intent);
            }
        });
        final ImagePopup imagePopup=new ImagePopup(this);
        imagePopup.setWindowHeight(800);
        imagePopup.setWindowHeight(800);
        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);
        imagePopup.initiatePopup(imgdl.getDrawable());

        imgdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup.viewPopup();
            }
        });

    }
}

