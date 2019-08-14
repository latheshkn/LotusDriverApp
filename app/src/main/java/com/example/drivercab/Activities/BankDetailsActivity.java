package com.example.drivercab.Activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.drivercab.DriverBankDetailModel.BankResponse;
        import com.example.drivercab.DriverBankDetailModel.DriverBankDetailrecyclerAdapter;
        import com.example.drivercab.OtpVarificationModel.Otp;
        import com.example.drivercab.R;
        import com.example.drivercab.Retrofit.Api;
        import com.example.drivercab.Retrofit.BaseClient;

        import java.net.HttpURLConnection;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class BankDetailsActivity extends AppCompatActivity {
    TextView  txtaccountno, txtifscno, txtbanknameenter;
    RecyclerView recyclerviewbankdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

//        txtaccountno = findViewById(R.id.txtaccountno);
//        txtifscno = findViewById(R.id.txtifscno);
//        txtbanknameenter = findViewById(R.id.txtbanknameenter);
        recyclerviewbankdetail=findViewById(R.id.recyclerbankdetail);
        recyclerviewbankdetail.setLayoutManager(new LinearLayoutManager(this));
        getRecipe();

    }

    private void getRecipe() {
        Otp otp=SharedPrefManager.getInstance(BankDetailsActivity.this).getUser();
        String  Bankid=otp.getDid();

        Toast.makeText(this,Bankid, Toast.LENGTH_SHORT).show();
        //    Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<BankResponse> call = recipeHomeApi.bankdetail(Bankid);

        call.enqueue(new Callback<BankResponse>() {
            @Override
            public void onResponse(Call<BankResponse> call, Response<BankResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK == response.code()) {
                    BankResponse abd = response.body();
                    DriverBankDetailrecyclerAdapter adapter=new DriverBankDetailrecyclerAdapter(abd.getData());
                    recyclerviewbankdetail.setAdapter(adapter);
                    Toast.makeText(BankDetailsActivity.this,"Success",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BankDetailsActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<BankResponse> call, Throwable t) {

                Toast.makeText(BankDetailsActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
