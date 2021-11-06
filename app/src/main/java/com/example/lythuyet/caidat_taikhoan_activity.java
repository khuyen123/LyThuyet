package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class caidat_taikhoan_activity extends AppCompatActivity {
    Button back;
    BottomNavigationView bot_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtintaikhoan);
        bot_nav=findViewById(R.id.tttaikhoan_bot_nav);
        back = findViewById(R.id.caidat_back);
        bot_nav.setSelectedItemId(R.id.taikhoan);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu_activity.class));

                        overridePendingTransition(0,0);
                        break;

                    case  R.id.thuonghieu:
                        startActivity(new Intent(getApplicationContext(),thuonghieu_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.theodoi:
                        startActivity(new Intent(getApplicationContext(),theodoi_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.taikhoan:
                        startActivity(new Intent(getApplicationContext(),taikhoan_activity.class));

                        overridePendingTransition(0,0);
                        break;
                    case R.id.giohang:
                        startActivity(new Intent(getApplicationContext(),giohang_activity.class));

                        overridePendingTransition(0,0);
                        break;

                }
                return false;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(caidat_taikhoan_activity.this,taikhoan_activity.class);
                startActivity(intent);

            }
        });
    }
}