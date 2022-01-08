package com.example.lythuyet;

public class HomeSanPham {
    private String tenShop;
    private String moTa;
    private String chiTiet;
    private int anh;

    public HomeSanPham(String tenShop, String moTa, String chiTiet, int anh) {
        this.tenShop = tenShop;
        this.moTa = moTa;
        this.chiTiet = chiTiet;
        this.anh = anh;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String lienHe) {
        this.chiTiet = lienHe;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
