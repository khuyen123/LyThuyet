package com.example.lythuyet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class thanhtoan_activity extends AppCompatActivity {
    BottomNavigationView bot_nav;
    Button button,dangxuat;
    Bundle bundle;
    TaiKhoan taiKhoan;
    TextView ten,sdt,diachi,tongtien;
    EditText magiam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_thanhtoan);
        button = findViewById(R.id.dat_hang);
        bot_nav = findViewById(R.id.thanhtoan_bottom_nav);
        magiam= findViewById(R.id.magiam);
        ten=findViewById(R.id.tennhanhang);
        sdt=findViewById(R.id.sdtnhanhang);
        tongtien=findViewById(R.id.tongtien);
        diachi=findViewById(R.id.diachinhanhang);
        bot_nav.setSelectedItemId(R.id.giohang);
        getuser();
        giamgia();
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanhtoan_activity.this);
                builder.setTitle("Thanh Toán");
                builder.setMessage("Đặt hàng thành công");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
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
        sdt.setText(taiKhoan.getSdt());
        diachi.setText(taiKhoan.getDiachi());
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
    public void giamgia()
    {
        magiam.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phieugiam=magiam.getText().toString();
                if((phieugiam.equals("Noel"))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(thanhtoan_activity.this);
                    builder.setTitle("Thanh Toán");
                    builder.setMessage("Bấm OK để áp dụng mã thanh toán");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                    tongtien.setText("đ100.842");
                }
                if ((phieugiam.equals("TetNguyenDan")))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(thanhtoan_activity.this);
                    builder.setTitle("Thanh Toán");
                    builder.setMessage("Bấm OK để áp dụng mã thanh toán");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                    tongtien.setText("đ80.842");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}