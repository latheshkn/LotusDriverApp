package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.drivercab.CarProfileModel.CarProfileResponse;
import com.example.drivercab.CarProfileModel.CarProfilerecyclerAdapter;
import com.example.drivercab.DriverProfilemodel.ProfileResponse;
import com.example.drivercab.DriverProfilemodel.ProfileaRecyclerAdapter;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarProfileActivity extends AppCompatActivity {
//ConstraintLayout constraintdocument;
RecyclerView recyclercarprofile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_profile);
//        constraintdocument=findViewById(R.id.constraintdocument);
//
//        constraintdocument.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(CarProfileActivity.this,CarDocumentActivity.class);
//                startActivity(intent);
//            }
//        });
        recyclercarprofile=findViewById(R.id.recyclercarprofile);
        recyclercarprofile.setLayoutManager(new LinearLayoutManager(this));
        getRecipe();
    }


    private void getRecipe() {
        Otp otp=SharedPrefManager.getInstance(CarProfileActivity.this).getUser();
        String did=otp.getDid();
        //    Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<CarProfileResponse> call = recipeHomeApi.getcarprofile(did);

        call.enqueue(new Callback<CarProfileResponse>() {
            @Override
            public void onResponse(Call<CarProfileResponse> call, Response<CarProfileResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK==response.code()){
                    CarProfileResponse abd =  response.body();


                    CarProfilerecyclerAdapter adapter = new CarProfilerecyclerAdapter(abd.getData());
                    recyclercarprofile.setAdapter(adapter);
                    Toast.makeText(CarProfileActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CarProfileActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<CarProfileResponse> call, Throwable t) {

                Toast.makeText(CarProfileActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
