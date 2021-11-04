package com.example.lythuyet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class caidat_activity extends AppCompatActivity {
    Button caidat_xemtaikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.singup_activity);
        caidat_xemtaikhoan = (Button) findViewById(R.id.caidat_xemtaikhoan);

        caidat_xemtaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(caidat_activity.this, logined.class);
                startActivity(intent);
            }
        });
    }
}