package com.example.lythuyet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class singup_activity extends AppCompatActivity {
    Button login_button,sigup_button;
    EditText email,matkhau,hoten,diachi,sdt;
    TextView alertemail,alermatkhau,alerthoten,alertdiachi,alertsdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.singup_activity);
        anhxa();
        kiemtradulieu();
        sigup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dangky();
            }
        });
            login_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(singup_activity.this,logined.class);
                    startActivity(intent);
                }
            });
    }
    private void anhxa()
    {
        email=findViewById(R.id.edt_email);
        matkhau=findViewById(R.id.edt_matKhau);
        hoten=findViewById(R.id.edt_ten);
        diachi=findViewById(R.id.edt_diachi);
        sdt=findViewById(R.id.edt_sdt);
        alertemail=findViewById(R.id.aleremail);
        alermatkhau=findViewById(R.id.alermatkhau);
        alertdiachi=findViewById(R.id.alerdiachi);
        alerthoten=findViewById(R.id.alerhoten);
        alertsdt=findViewById(R.id.alersdt);
        login_button = (Button) findViewById(R.id.login_singup);
        sigup_button = (Button) findViewById(R.id.singup_signup);

    }

    public void kiemTraemail()
    {
        String emailpattern= "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String emailString=email.getText().toString();
                if (!Pattern.matches(emailpattern,emailString))
                {
                    email.setBackgroundResource(R.drawable.alert_edit);
                    alertemail.setText("Email sai định dạng");
                } else {
                    email.setBackgroundResource(R.drawable.edt_boder);
                    alertemail.setText("");
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void kiemTraMatKhau()
    {
        String hoTenparten= "[a-zA-Z!@#$%^&0-9]*";

        matkhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String matKhauString=matkhau.getText().toString();
                if (!Pattern.matches(hoTenparten,matKhauString))
                {
                    matkhau.setBackgroundResource(R.drawable.alert_edit);
                    alermatkhau.setText("Mật khẩu chir chứa chữ cái,số và @#$%^&");
                } else {
                    matkhau.setBackgroundResource(R.drawable.edt_boder);
                    alermatkhau.setText("");
                }
                if(matKhauString==null)
                {
                    matkhau.setBackgroundResource(R.drawable.alert_edit);
                    alermatkhau.setText("Mật khẩu là bắt buộc");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void kiemTradiachi()
    {
        String hoTenparten= "[a-zA-ZáàảãạâấầẫẩậăắằẳẵặèéẻẽẹđêếềểễệìíịĩỉòóỏõọĂÂÊĐÔ ôốồổỗộơớờởỡợủũùúụưứừửữự]*";

        diachi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String diachiString=diachi.getText().toString();
                if (!Pattern.matches(hoTenparten,diachiString))
                {
                    diachi.setBackgroundResource(R.drawable.alert_edit);
                    alertdiachi.setText("Địa chỉ chỉ chứa các chữ cái");
                } else {
                    diachi.setBackgroundResource(R.drawable.edt_boder);
                    alertdiachi.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void kiemTraHoTen()
    {
        String hoTenparten= "[a-zA-ZáàảãạâấầẫẩậăắằẳẵặèéẻẽẹđêếềểễệìíịĩỉòóỏõọĂÂÊĐÔ ôốồổỗộơớờởỡợủũùúụưứừửữự]*";

        hoten.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String hotenString=hoten.getText().toString();
                if (!Pattern.matches(hoTenparten,hotenString))
                {
                    hoten.setBackgroundResource(R.drawable.alert_edit);
                    alerthoten.setText("Họ tên chỉ chứa các chữ cái");
                } else {
                    hoten.setBackgroundResource(R.drawable.edt_boder);
                    alerthoten.setText("");
                }
                if(hotenString==null)
                {
                    hoten.setBackgroundResource(R.drawable.alert_edit);
                    alerthoten.setText("Họ tên là bắt buộc");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void kiemTraSDT()
    {


        sdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String hotenString=sdt.getText().toString();
                if (hotenString.length()!=10)
                {
                    sdt.setBackgroundResource(R.drawable.alert_edit);
                    alertsdt.setText("Số điện thoại gồm 11 chữ số");
                } else {
                    sdt.setBackgroundResource(R.drawable.edt_boder);
                    alertsdt.setText("");
                }
                if(hotenString==null)
                {
                    sdt.setBackgroundResource(R.drawable.alert_edit);
                    sdt.setText("Số điện thoại là bắt buộc");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void kiemtradulieu()
    {

        kiemTraHoTen();
        kiemTraMatKhau();
        kiemTraemail();
        kiemTraSDT();
        kiemTradiachi();

    }
    private int kiemtradulieuThem()
    {
        String a,b,c,d,e;
        a=alertsdt.getText().toString();
        b=alerthoten.getText().toString();
        c=alertdiachi.getText().toString();
        d=alertemail.getText().toString();
        e=alermatkhau.getText().toString();
        if(a.equals("")&&b.equals("")&&c.equals("")&&d.equals("")&&e.equals(""))
        {
            return 1;
        }
        return 0;
    }
    private  void kiemtralandau()
    {
        String a= sdt.getText().toString();
        String b= hoten.getText().toString();
        String c= matkhau.getText().toString();
        String d= diachi.getText().toString();
        String e= email.getText().toString();
        if(a.equals(""))
        {
            alertsdt.setText("Số điện thoại là bắt buộc");
            sdt.setBackgroundResource(R.drawable.alert_edit);
        }

        if(b.equals(""))
        {
            alerthoten.setText("Họ tên là bắt buộc");
            hoten.setBackgroundResource(R.drawable.alert_edit);
        }

        if(c.equals(""))
        {
            alermatkhau.setText("Mật khẩu là bắt buộc");
            matkhau.setBackgroundResource(R.drawable.alert_edit);
        }

        if(d.equals(""))
        {
            alertdiachi.setText("Địa chỉ là bắt buộc");
            diachi.setBackgroundResource(R.drawable.alert_edit);
        }
        if(e.equals(""))
        {
            alertemail.setText("Email là bắt buộc");
            email.setBackgroundResource(R.drawable.alert_edit);
        }

    }
    private void dangky()
    {
        kiemtralandau();
        if(kiemtradulieuThem()==1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(singup_activity.this);
            builder.setTitle("Đăng ký");
            builder.setMessage("Đăng ký thành công! Bấm Ok để đăng nhập");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(singup_activity.this, logined.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", 3);
                    bundle.putString("tendangnhap", sdt.getText().toString());
                    bundle.putString("matkhau", matkhau.getText().toString());
                    bundle.putString("hoten", hoten.getText().toString());
                    bundle.putString("ngaysinh", "");
                    bundle.putString("diachi", diachi.getText().toString());
                    bundle.putString("gioitinh", "Nam");
                    bundle.putString("email", email.getText().toString());
                    bundle.putString("sdt", sdt.getText().toString());
                    bundle.putInt("sodu", 0);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            builder.show();
        }
    }
}