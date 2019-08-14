package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drivercab.MobileNoEnterModel.MobileNoResponse;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    EditText entr_mob_no_editText;
    Button get_otp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        entr_mob_no_editText = (EditText) findViewById(R.id.simpleEditText);
        get_otp_btn = (Button) findViewById(R.id.get_otp_btn);

        updateNumber();

        //Setting onClick listner to getOTP Button
        get_otp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToVerifyOTPactivity();
            }
        });

    }




    private void goToVerifyOTPactivity() {

        final String mobile_num = entr_mob_no_editText.getText().toString();



        if (mobile_num.length() < 10 || mobile_num.length() > 10) {
            entr_mob_no_editText.setError("Enter The Correct Number");
            entr_mob_no_editText.requestFocus();
            return;
        }

        Api lotusCabApi = BaseClient.getBaseClient().create(Api.class);
        Call<MobileNoResponse> call = lotusCabApi.enterMobileNum(mobile_num);

        call.enqueue(new Callback<MobileNoResponse>() {
            @Override
            public void onResponse(Call<MobileNoResponse> call, Response<MobileNoResponse> response) {
                if (response.isSuccessful()) {



                        Toast.makeText(SignInActivity.this, "SS", Toast.LENGTH_SHORT).show();
                        Toast.makeText(SignInActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignInActivity.this, GetOtpActivity.class);
                        //sending mobile number to Enter OTP Activity so that we can display that number their
                        Bundle bundle = new Bundle();
                        bundle.putString("mobNum", mobile_num);
                        bundle.putString("mobN", mobile_num);
                        intent.putExtras(bundle);

                        startActivity(intent);
                        finish();



                } else {
                    Toast.makeText(SignInActivity.this, "unSucessfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MobileNoResponse> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                Toast.makeText(SignInActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    // this method will call when the user try to update number in Setting and will come to Enter number Activity
    private void updateNumber() {

        // here we get the number that user put in update number EditText in PhoneNumber  Activity
        Bundle bundle = getIntent().getExtras();
        if (getIntent().hasExtra("moblNum")) {
            String numb = getIntent().getStringExtra("moblNum");
            entr_mob_no_editText.setText(numb);
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }


}
