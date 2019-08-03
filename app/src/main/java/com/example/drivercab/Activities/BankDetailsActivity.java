package com.example.drivercab.Activities;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

        import com.example.drivercab.R;

public class BankDetailsActivity extends AppCompatActivity {
TextView txtedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        txtedit=findViewById(R.id.txtedit);
        txtedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BankDetailsActivity.this,EditBankDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
