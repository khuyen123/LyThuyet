package com.example.lythuyet;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    int id;
    String tendangnhap,matkhau,hoten,ngaysinh,diachi,gioitinh,email,sdt;
    int sodu;
    public int getId() {
        return id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public int getSodu() {
        return sodu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setSodu(int sodu) {
        this.sodu = sodu;
    }

    public TaiKhoan(int id, String tendangnhap, String matkhau, String hoten, String ngaysinh, String diachi, String gioitinh, String email, String sdt, int sodu) {
        this.id = id;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.email = email;
        this.sdt = sdt;
        this.sodu = sodu;
    }


}
