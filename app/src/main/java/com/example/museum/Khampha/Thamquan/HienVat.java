package com.example.museum.Khampha.Thamquan;

import java.util.List;

public class HienVat {
    private String tenHienVat;
    private String thoiLuong;
    private String thongTin;
    private String museum;
    private String audioSource;
    private int hinhAnh;
    private String firstHinhAnh;
    private String author;
    private List<String> listImage;
    private String id;
    public HienVat(String id, String tenHienVat, List<String> listImage, String information, String audioSource, String museum) {
        this(id, tenHienVat, listImage, information, audioSource, museum, "");
    }

    public HienVat(String id, String tenHienVat, List<String> listImage, String information, String audioSource, String museum, String author) {
        this.id = id;
        this.tenHienVat = tenHienVat;
        this.listImage = listImage;
        this.thongTin = information;
        this.audioSource = audioSource;
        this.museum = museum;
        this.author = author;
        this.firstHinhAnh = listImage.get(0);
    }





    public HienVat(String tenHienVat, String thoiLuong, String thongTin, String museum, String audioSource, int hinhAnh) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = thoiLuong;
        this.thongTin = thongTin;
        this.museum = museum;
        this.audioSource = audioSource;
        this.hinhAnh = hinhAnh;
    }

    public HienVat(String tenHienVat, String s, String s1, int hinhAnh, String audioSource) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = s;
        this.thongTin = s1;
        this.hinhAnh = hinhAnh;
        this.audioSource =audioSource;
    }
    public HienVat(String tenHienVat, String s, String s1) {
        this.tenHienVat = tenHienVat;
        this.thoiLuong = s;
        this.thongTin = s1;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HienVat(String tenHienVat, String author, int hinhAnh) {
        this.tenHienVat = tenHienVat;
        this.author = author;
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

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public void setAudioSource(String audioSource) {
        this.audioSource=audioSource;
    }
    public String getTenHienVat() {
        return tenHienVat;
    }

    public String getThoiLuong() {
        if (thoiLuong == null) {
            return "";
        }
        return thoiLuong;
    }

    public String getThongTin() {
        return thongTin;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }
    public String getAudioSource() {
        return audioSource;
    }

    public String getFirstHinhAnh() {
        return firstHinhAnh;
    }

    public String getID() {
        return id;
    }

    public List<String> getListImage() {
        return listImage;
    }


    public String getMuseum() {
        return museum;
    }
}
