package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetOtpActivity extends AppCompatActivity {
    Button verify_btn;
    FrameLayout replace;
    EditText otp_edit_text;
    int OTP = 1;
    TextView enter_otp_txt;
    String mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp);
        verify_btn = findViewById(R.id.verify_btn);
        replace = findViewById(R.id.replace);
        otp_edit_text = findViewById(R.id.otp_edit_text);
        enter_otp_txt = findViewById(R.id.enter_otp_txt);
        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();
            }
        });

        Bundle bundle = getIntent().getExtras();
         mob = bundle.getString("mobNum");

        enter_otp_txt.setText("Enter OTP sent to" + " " + mob);


    }

    private void login() {

        String otp = otp_edit_text.getText().toString();

        if (otp.isEmpty() && otp.length()< 6) {
            otp_edit_text.setError("Enter Otp");
            otp_edit_text.requestFocus();
            return;
        }

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<Otp> call = recipeHomeApi.getverify(mob,otp);

        call.enqueue(new Callback<Otp>() {
            @Override
            public void onResponse(Call<Otp> call, Response<Otp> response) {
                if (response.isSuccessful()) {
                    Otp verifyOtpResponse = response.body();
                    //if the authentaction is sucessfull we will save the user
                    SharedPrefManager.getInstance(GetOtpActivity.this)
                            .saveUser(verifyOtpResponse); //we

                    Intent intent = new Intent(GetOtpActivity.this, RegistrationPageActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(GetOtpActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GetOtpActivity.this, "unsuccess", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Otp> call, Throwable t) {

                Toast.makeText(GetOtpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(GetOtpActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

}
