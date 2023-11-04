package com.example.museum.Khampha.Thamquan;

public class HienVat {
    private String tenHienVat;
    private String thoiLuong;
    private String thongTin;
    private String chude;
    private int hinhAnh;

    public HienVat(String tenHienVat, String thoiLuong, String thongTin,String chude, int hinhAnh) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = thoiLuong;
        this.thongTin = thongTin;
        this.chude = chude;
        this.hinhAnh = hinhAnh;
    }

    public HienVat(String tenHienVat, String s, String s1, int hinhAnh) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = s;
        this.thongTin = s1;
        this.hinhAnh = hinhAnh;
    }
    public HienVat(String tenHienVat, String s, String s1) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = s;
        this.thongTin = s1;
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

    public void setHinhAnh(int hinhAnh) {
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

    public int getHinhAnh() {
        return hinhAnh;
    }
}
