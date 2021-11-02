package com.example.lythuyet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class singup_activity extends AppCompatActivity {
    Button login_button,sigup_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.singup_activity);
        login_button = (Button) findViewById(R.id.login_singup);
        sigup_button = (Button) findViewById(R.id.singup_signup);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(singup_activity.this, logined.class);
                startActivity(intent);
            }
        });
        sigup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(singup_activity.this,"Đăng ký thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}