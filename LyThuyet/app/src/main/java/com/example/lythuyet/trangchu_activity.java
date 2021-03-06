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

        // t???o theo constructor
        homeSanPhams.add(new HomeSanPham("CATAN", "R??m c???a cao c???p, ch???ng n???ng t???t","Mua h??ng", R.drawable.sp_img));
        homeSanPhams.add(new HomeSanPham("VICTORYA", "R??m c???a cao c???p d??nh cho th?????ng l??u","Mua h??ng", R.drawable.sp_img));
        homeSanPhams.add(new HomeSanPham("ACANA", "R??m c???a v???i nh???p kh???u ch??nh h??ng","Mua h??ng", R.drawable.acana));
        homeSanPhams.add(new HomeSanPham("T??N T??M", "R??m c???a c???a ng?????i vi???t","Mua h??ng", R.drawable.tintam));
        homeSanPhams.add(new HomeSanPham("Curtains & Blinds", "Nh???p kh???u ?????c","Mua h??ng", R.drawable.curtan));
        homeSanPhams.add(new HomeSanPham("Avina", "R??m ???????c ??a chu???ng","Mua h??ng", R.drawable.avina));
        homeSanPhams.add(new HomeSanPham("PH??C NGUY??N", "R??m Ph??c Nguy??n","Mua h??ng", R.drawable.phucnguyen));
    }
}