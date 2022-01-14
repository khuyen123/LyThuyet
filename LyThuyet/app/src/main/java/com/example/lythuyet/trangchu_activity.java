package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class trangchu_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button but;
    ListView lsvHomeSanPham;
    ArrayList<HomeSanPham> homeSanPhams;
    HomeSanPhamAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.trangchu_layout);
        bot_nav = findViewById(R.id.trangchu_bottom_nav);
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

        anhXa();
        adapter = new HomeSanPhamAdapter(this, R.layout.home_item_listview, homeSanPhams);
        lsvHomeSanPham.setAdapter(adapter);
    }
    private void anhXa(){
        lsvHomeSanPham= (ListView) findViewById(R.id.lsv_home);
        homeSanPhams = new ArrayList<>();

        // tạo theo constructor
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm phòng khách","Thêm vào giỏ", R.drawable.catanshop));
    }
}