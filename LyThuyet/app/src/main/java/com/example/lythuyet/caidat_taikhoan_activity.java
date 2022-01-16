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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class caidat_taikhoan_activity extends AppCompatActivity {
    Button back,luu;
    Bundle bundle;
    TaiKhoan taiKhoan;
    BottomNavigationView bot_nav;
    EditText ten,sdt,email,diachi,ngaysinh;
    TextView gioitinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.thongtintaikhoan);
        bot_nav=findViewById(R.id.tttaikhoan_bot_nav);
        back = findViewById(R.id.caidat_back);
        ten=findViewById(R.id.tentaikhoan);
        sdt=findViewById(R.id.sdttaikhoan);
        ngaysinh=findViewById(R.id.ngaysinh);
        gioitinh=findViewById(R.id.gioitinh);
        email=findViewById(R.id.emailtaikhoan);
        luu=findViewById(R.id.caidat_luu);
        diachi=findViewById(R.id.diachitaikhoan);
        bot_nav.setSelectedItemId(R.id.taikhoan);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putuser(taikhoan_activity.class);

            }
        });
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luu(taikhoan_activity.class);
            }
        });
    }
    public void putuser(Class activity)
    {
        Bundle bundle2= new Bundle();
        Intent intent= new Intent(this,activity);
        bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("matkhau",taiKhoan.getMatkhau());
        bundle2.putString("hoten",taiKhoan.getHoten());
        bundle2.putString("ngaysinh",taiKhoan.getNgaysinh());
        bundle2.putString("gioitinh",taiKhoan.getGioitinh());
        bundle2.putString("sdt",taiKhoan.getSdt());
        bundle2.putInt("sodu",taiKhoan.getSodu());
        bundle2.putInt("id",taiKhoan.getId());
        bundle2.putString("diachi",taiKhoan.getDiachi());
        bundle2.putString("email",taiKhoan.getEmail());
        intent.putExtras(bundle2);
        startActivity(intent);
    }
    public void luu(Class activity)
    {
        taiKhoan.setHoten(ten.getText().toString());
        taiKhoan.setDiachi(diachi.getText().toString());
        taiKhoan.setSdt(sdt.getText().toString());
        taiKhoan.setEmail(email.getText().toString());
        taiKhoan.setNgaysinh(ngaysinh.getText().toString());
        Bundle bundle2= new Bundle();
        Intent intent= new Intent(this,activity);
        bundle2.putString("tendangnhap",taiKhoan.getTendangnhap());
        bundle2.putString("matkhau",taiKhoan.getMatkhau());
        bundle2.putString("hoten",taiKhoan.getHoten());
        bundle2.putString("ngaysinh",taiKhoan.getNgaysinh());
        bundle2.putString("gioitinh",taiKhoan.getGioitinh());
        bundle2.putString("sdt",taiKhoan.getSdt());
        bundle2.putInt("sodu",taiKhoan.getSodu());
        bundle2.putInt("id",taiKhoan.getId());
        bundle2.putString("diachi",taiKhoan.getDiachi());
        bundle2.putString("email",taiKhoan.getEmail());
        intent.putExtras(bundle2);
        startActivity(intent);
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
       ten.setText(taiKhoan.getHoten());
       diachi.setText(taiKhoan.getDiachi());
       sdt.setText(taiKhoan.getSdt());
       email.setText(taiKhoan.getEmail());
       ngaysinh.setText(taiKhoan.getNgaysinh());
       gioitinh.setText(taiKhoan.getGioitinh());
    }

}