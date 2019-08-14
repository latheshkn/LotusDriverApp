package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drivercab.ContactModel.ContactResponse;
import com.example.drivercab.NameUpateModel.NameResponse;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {
Toolbar toolbar;
EditText edtname,edtemail,edtmessage;
Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        toolbar=findViewById(R.id.toolprofile);
        edtname=findViewById(R.id.edtname);
        edtemail=findViewById(R.id.edtemail);
        edtmessage=findViewById(R.id.edtmessage);
        btnsubmit=findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


       setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void login() {

        String name = edtname.getText().toString();
        String email = edtemail.getText().toString();
        String message = edtmessage.getText().toString();


        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<ContactResponse> call = recipeHomeApi.getcontact(name,email,message);

        call.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                if (response.isSuccessful()) {
                    ContactResponse nameResponse = response.body();
                    String s = nameResponse.toString();
                    Toast.makeText(ContactActivity.this, s, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(DriverNameUpdateActivity.this, RegistrationActivity.class);
//                    startActivity(intent);
                    Toast.makeText(ContactActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContactActivity.this, "UnSucessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {

                Toast.makeText(ContactActivity.this, "kjk", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
