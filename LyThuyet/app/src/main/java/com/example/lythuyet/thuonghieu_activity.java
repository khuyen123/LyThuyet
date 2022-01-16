package com.example.lythuyet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class thuonghieu_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Bundle bundle;
    TaiKhoan taiKhoan;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.thuonghieu_layout);
        bot_nav =findViewById(R.id.thuonghieu_bot_nav);
        tabLayout= findViewById(R.id.thuonghieu_tab_layout);
        viewPager = findViewById(R.id.thuonghieu_view_paper);
        bot_nav.setSelectedItemId(R.id.thuonghieu);
        getuser();
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu_activity.class));
                        putuser(trangchu_activity.class);
                        overridePendingTransition(0,0);
                        break;

                    case  R.id.thuonghieu:
                        putuser(thuonghieu_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.theodoi:
                        putuser(theodoi_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.taikhoan:
                        putuser(taikhoan_activity.class);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.giohang:
                        putuser(giohang_activity.class);
                        overridePendingTransition(0,0);
                        break;

                }
                return false;
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        thuonghieu_tab_adapter thuonghieuTabAdapter= new thuonghieu_tab_adapter(getSupportFragmentManager());
        thuonghieuTabAdapter.addFrag(new thuonghieu_dangsale_frag(),"Đang Sale");
        thuonghieuTabAdapter.addFrag(new thuonghieu_khaitruong_frag(),"Mới khai trương");
        thuonghieuTabAdapter.addFrag(new thuonghieu_doanhthu_frag(),"Doanh thu cao");
        viewPager.setAdapter(thuonghieuTabAdapter);
    }
    public void getuser()
    {
        bundle=getIntent().getExtras();
        taiKhoan = new TaiKhoan(
                bundle.getInt("id", 0),
                bundle.getString("tendangnhap"),
                bundle.getString("matkhau"),
                bundle.getString("hoten"),
                bundle.getString("ngaysinh"),
                bundle.getString("diachi"),
                bundle.getString("gioitinh"),
                bundle.getString("email"),
                bundle.getString("sdt"),
                bundle.getInt("sodu")
        );

    }
    public void putuser(Class activity)
    {
        Bundle bundle2= new Bundle();
        Intent intent= new Intent(this,activity);
        bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("matkhau",taiKhoan.getMatkhau());
        bundle2.putString("hoten",taiKhoan.getHoten());
        bundle2.putString("ngaysinh",taiKhoan.getNgaysinh());
        bundle2.putString("gioitinh",taiKhoan.getGioitinh());bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("sdt",taiKhoan.getSdt());
        bundle2.putInt("sodu",taiKhoan.getSodu());
        bundle2.putInt("id",taiKhoan.getId());
        bundle2.putString("diachi",taiKhoan.getDiachi());
        bundle2.putString("email",taiKhoan.getEmail());
        intent.putExtras(bundle2);
        startActivity(intent);
    }
}