package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.drivercab.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;

public class DriverProfileActivity extends AppCompatActivity {
    ConstraintLayout constraintdriverdoc, constraintprofile;
    Toolbar toolprofile;
     Uri imageuri;
    private static final int PICK_IMAGE=1;
    CircularImageView profileimage;
    private static int RESULT_LOAD_IMAGE = 1;
    BitmapDrawable drawable;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);
        constraintdriverdoc = findViewById(R.id.constraintdriverdoc);
        toolprofile = findViewById(R.id.toolprofile);
        setSupportActionBar(toolprofile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      //  profileimage = findViewById(R.id.profileimage);

        constraintprofile = findViewById(R.id.constraintprofile);
        profileimage=findViewById(R.id.profileimage);

        constraintprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery=new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,"select picture"),PICK_IMAGE);


            }
        });

        constraintdriverdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DriverProfileActivity.this, DriverDocumentsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if (requestCode==PICK_IMAGE && resultCode==RESULT_OK)    {
         imageuri=data.getData();
         try{
             Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
             profileimage.setImageBitmap(bitmap);

         }catch (IOException e){
             e.printStackTrace();
         }
       }
    }
}
