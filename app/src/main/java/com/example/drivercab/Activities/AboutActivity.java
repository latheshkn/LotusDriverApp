package com.example.drivercab.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drivercab.AboutPageModel.About;
import com.example.drivercab.AboutPageModel.AboutRecyclerviewAdapter;
import com.example.drivercab.AboutPageModel.AboutResponse;
import com.example.drivercab.R;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutActivity extends AppCompatActivity {
    Toolbar tool;
    List<About> aboutResponses;
    TextView txtabout;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        recycler = (RecyclerView)findViewById(R.id.recycler);
        tool=findViewById(R.id.tool);

        setSupportActionBar(tool);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tool.setTitle("About");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        getRecipe();

    }

    private void getRecipe() {

        //    Integer sessionId = Integer.valueOf(getIntent().getStringExtra("EXTRA_SESSION_ID"));

        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<AboutResponse> call = recipeHomeApi.aboutresponce("kkl");

        call.enqueue(new Callback<AboutResponse>() {
            @Override
            public void onResponse(Call<AboutResponse> call, Response<AboutResponse> response) {
                if (response.isSuccessful() && HttpURLConnection.HTTP_OK==response.code()){
                    AboutResponse abd =  response.body();

                    AboutRecyclerviewAdapter adapter = new AboutRecyclerviewAdapter(abd.getData());
                    recycler.setAdapter(adapter);
                }else {
                    Toast.makeText(AboutActivity.this, "Unscuessfull", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<AboutResponse> call, Throwable t) {

                Toast.makeText(AboutActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
