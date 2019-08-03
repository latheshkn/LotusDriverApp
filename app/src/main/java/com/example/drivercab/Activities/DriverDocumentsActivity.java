package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.example.drivercab.R;

public class DriverDocumentsActivity extends AppCompatActivity {
    ImageView imgadress,imglicense,imgcopy;
    Toolbar toolbar;
    Button btnedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_documents);

        toolbar=findViewById(R.id.tooldrivedoc);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnedit=findViewById(R.id.btnedit);
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DriverDocumentsActivity.this,EditdriverDocuments.class);
                startActivity(intent);
            }
        });

        final ImagePopup imagePopup = new ImagePopup(this);
        imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setBackgroundColor(Color.BLACK);  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional

        imgadress = (ImageView) findViewById(R.id.imgadress);
        imagePopup.initiatePopup(imgadress.getDrawable());

        imglicense = (ImageView) findViewById(R.id.imglicense);
        imagePopup.initiatePopup(imglicense.getDrawable());

        imgcopy = (ImageView) findViewById(R.id.imgcopy);
        imagePopup.initiatePopup(imgcopy.getDrawable());


        imgadress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                imagePopup.viewPopup();

            }
        });

        imglicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                imagePopup.viewPopup();

            }
        });
        imgcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                imagePopup.viewPopup();

            }
        });
    }
}
