package com.example.wubingzhang.week9.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wubingzhang.week9.R;

public class account extends AppCompatActivity {
    Button viewAnalysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        viewAnalysis = (Button)findViewById(R.id.analysis);
        viewAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(account.this,viewAnalysis.class);
                startActivity(intent);
                account.this.finish();
            }
        });
    }
}
