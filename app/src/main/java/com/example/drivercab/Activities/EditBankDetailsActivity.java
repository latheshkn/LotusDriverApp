package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drivercab.DriverBankDetailEditModel.Example;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditBankDetailsActivity extends AppCompatActivity {
    EditText edtname, edtifsc, edtaccountno, edtcnfrm;

    Button btncontinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bank_details);
        edtname = findViewById(R.id.edtname);
        edtifsc = findViewById(R.id.edtifsc);
        edtaccountno = findViewById(R.id.edtaccountno);
        edtcnfrm = findViewById(R.id.edtcnfrm);
        btncontinue=findViewById(R.id.btncontinue);

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    private void login() {

        String name = edtname.getText().toString();
        String ifsc = edtifsc.getText().toString();
        String accountno = edtifsc.getText().toString();
        String bnakname = edtifsc.getText().toString();

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<Example> call = recipeHomeApi.editbank(name,ifsc, accountno, bnakname);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {

                    Intent intent = new Intent(EditBankDetailsActivity.this, BankDetailsActivity.class);
                    startActivity(intent);
                    Toast.makeText(EditBankDetailsActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditBankDetailsActivity.this, "UnSucessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Toast.makeText(EditBankDetailsActivity.this, "kjk", Toast.LENGTH_SHORT).show();
            }
        });
    }
}