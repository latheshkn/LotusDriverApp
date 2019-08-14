package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivercab.AboutPageModel.AboutRecyclerviewAdapter;
import com.example.drivercab.AboutPageModel.AboutResponse;
import com.example.drivercab.DriverProfilemodel.Profile;
import com.example.drivercab.DriverProfilemodel.ProfileResponse;
import com.example.drivercab.DriverProfilemodel.ProfileaRecyclerAdapter;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DriverProfileActivity extends AppCompatActivity {

    Toolbar toolprofile;
     Uri imageuri;
    private static final int PICK_IMAGE=1;
    CircularImageView profileimage;
    private static int RESULT_LOAD_IMAGE = 1;
    BitmapDrawable drawable;
    Bitmap bitmap;
    TextView name;
    RecyclerView recyclerprofile ;
    String Mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);

        toolprofile = findViewById(R.id.toolprofile);
        setSupportActionBar(toolprofile);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerprofile=findViewById(R.id.recyclerprofile);
        recyclerprofile.setLayoutManager(new LinearLayoutManager(this));

      //  profileimage = findViewById(R.id.profileimage);

//        constraintprofile = findViewById(R.id.constraintprofile);
        profileimage=findViewById(R.id.profileimage);
        name=findViewById(R.id.name);




        getRecipe();
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

    private void getRecipe() {
        Otp otp=SharedPrefManager.getInstance(DriverProfileActivity.this).getUser();
        Mobile=otp.getMobile();
        //    Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<ProfileResponse> call = recipeHomeApi.getprofile(Mobile);

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK==response.code()){
                    ProfileResponse abd =  response.body();


                    ProfileaRecyclerAdapter adapter = new ProfileaRecyclerAdapter(abd.getData());
                    recyclerprofile.setAdapter(adapter);
                    Toast.makeText(DriverProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DriverProfileActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

                Toast.makeText(DriverProfileActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
