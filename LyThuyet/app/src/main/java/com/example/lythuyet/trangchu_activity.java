package com.example.lythuyet;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class trangchu_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button but;
    TextView name,sodu;
    ListView lsvHomeSanPham;
    ArrayList<HomeSanPham> homeSanPhams;
    HomeSanPhamAdapter adapter;
    Bundle bundle;
    String ten;
    TaiKhoan taiKhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.trangchu_layout);
        anhXa();
        getuser();
        bot_nav = findViewById(R.id.trangchu_bottom_nav);

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


        adapter = new HomeSanPhamAdapter(this, R.layout.home_item_listview, homeSanPhams);
        lsvHomeSanPham.setAdapter(adapter);
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
        name.setText(taiKhoan.getHoten());
        sodu.setText(String.valueOf(taiKhoan.getSodu()));
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
    private void anhXa(){
        lsvHomeSanPham= (ListView) findViewById(R.id.lsv_home);
        homeSanPhams = new ArrayList<>();
        name=findViewById(R.id.name);
        sodu=findViewById(R.id.sodu);

        // tạo theo constructor
        homeSanPhams.add(new HomeSanPham("CATAN", "Rèm cửa cao cấp, chống nắng tốt","Mua hàng", R.drawable.sp_img));
        homeSanPhams.add(new HomeSanPham("VICTORYA", "Rèm cửa cao cấp dành cho thượng lưu","Mua hàng", R.drawable.sp_img));
        homeSanPhams.add(new HomeSanPham("ACANA", "Rèm cửa vải nhập khẩu chính hãng","Mua hàng", R.drawable.acana));
        homeSanPhams.add(new HomeSanPham("TÍN TÂM", "Rèm cửa của người việt","Mua hàng", R.drawable.tintam));
        homeSanPhams.add(new HomeSanPham("Curtains & Blinds", "Nhập khẩu Đức","Mua hàng", R.drawable.curtan));
        homeSanPhams.add(new HomeSanPham("Avina", "Rèm được ưa chuộng","Mua hàng", R.drawable.avina));
        homeSanPhams.add(new HomeSanPham("PHÚC NGUYÊN", "Rèm Phúc Nguyên","Mua hàng", R.drawable.phucnguyen));
    }
}