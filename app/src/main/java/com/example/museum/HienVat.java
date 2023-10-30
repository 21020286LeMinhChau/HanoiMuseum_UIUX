package com.example.museum;

public class HienVat {
    private String tenHienVat;
    private String thoiLuong;
    private String thongTin;
    private String hinhAnh;

    public HienVat(String tenHienVat, String s, String s1, String hinhAnh) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = s;
        this.thongTin = s1;
        this.hinhAnh = hinhAnh;
    }

    public void setTenHienVat(String tenHienVat) {
        this.tenHienVat = tenHienVat;
    }

    public void setThoiLuong(String thoiGian) {
        this.thoiLuong = thoiGian;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenHienVat() {
        return tenHienVat;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public String getThongTin() {
        return thongTin;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }
}
