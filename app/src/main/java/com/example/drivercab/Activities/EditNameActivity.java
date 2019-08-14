package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drivercab.NameUpateModel.NameResponse;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNameActivity extends AppCompatActivity {
    EditText edtname ;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

        edtname=findViewById(R.id.edtreg);
        btnsave=findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                Intent intent=new Intent(EditNameActivity.this,EditdriverDocuments.class);
                startActivity(intent);
            }
        });

    }
    private void login() {

        Otp otp=SharedPrefManager.getInstance(EditNameActivity.this).getUser();
        String mobile=otp.getMobile();

        String name = edtname.getText().toString();


        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<NameResponse> call = recipeHomeApi.updatename(mobile,name);

        call.enqueue(new Callback<NameResponse>() {
            @Override
            public void onResponse(Call<NameResponse> call, Response<NameResponse> response) {
                if (response.isSuccessful()) {
                    NameResponse nameResponse = response.body();
                    String s = nameResponse.toString();
                    Toast.makeText(EditNameActivity.this, s, Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(DriverNameUpdateActivity.this, RegistrationActivity.class);
//                    startActivity(intent);
                    Toast.makeText(EditNameActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditNameActivity.this, "UnSucessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NameResponse> call, Throwable t) {

                Toast.makeText(EditNameActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
