package com.example.museum.Khampha.DanhGia;

import android.graphics.drawable.Drawable;

import com.example.museum.R;

public class ListDanhGia {
    private String tenNguoiDanhGia;
    private String noiDungDanhGia;
    private int soSao;
    private String thoiGianDanhGia;
    private int avatar = 2;
    private int star1;
    private int star2;
    private int star3;
    private int star4;
    private int star5;

    public ListDanhGia(String tenNguoiDanhGia, String noiDungDanhGia, int soSao, String thoiGianDanhGia, int avatar) {
        this.tenNguoiDanhGia = tenNguoiDanhGia;
        this.noiDungDanhGia = noiDungDanhGia;
        this.soSao = soSao;
        this.thoiGianDanhGia = thoiGianDanhGia;
        this.avatar = avatar;
    }

    public ListDanhGia(String tenNguoiDanhGia, String noiDungDanhGia, int soSao, String thoiGianDanhGia, int avatar, int star1, int star2, int star3, int star4, int star5) {
        this.tenNguoiDanhGia = tenNguoiDanhGia;
        this.noiDungDanhGia = noiDungDanhGia;
        this.soSao = soSao;
        this.thoiGianDanhGia = thoiGianDanhGia;
        this.avatar = avatar;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        this.star5 = star5;
    }

    public ListDanhGia(Comment comment) {
        this.tenNguoiDanhGia = comment.getUser();
        this.noiDungDanhGia = comment.getComment();
        this.soSao = comment.getVote();
        this.thoiGianDanhGia = comment.getTimePrint();
        this.avatar = R.drawable.user;
        this.star1 = R.drawable.star;
        this.star2 = R.drawable.star;
        this.star3 = R.drawable.star;
        this.star4 = R.drawable.star;
        this.star5 = R.drawable.star;

    }

    public String getTenNguoiDanhGia() {
        return tenNguoiDanhGia;
    }

    public String getNoiDungDanhGia() {
        return noiDungDanhGia;
    }

    public int getSoSao() {
        return soSao;
    }

    public String getThoiGianDanhGia() {
        return thoiGianDanhGia;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setTenNguoiDanhGia(String tenNguoiDanhGia) {
        this.tenNguoiDanhGia = tenNguoiDanhGia;
    }

    public void setNoiDungDanhGia(String noiDungDanhGia) {
        this.noiDungDanhGia = noiDungDanhGia;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public void setThoiGianDanhGia(String thoiGianDanhGia) {
        this.thoiGianDanhGia = thoiGianDanhGia;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getStar1() {
        return star1;
    }

    public int getStar2() {
        return star2;
    }

    public int getStar3() {
        return star3;
    }

    public int getStar4() {
        return star4;
    }

    public int getStar5() {
        return star5;
    }

    public void setStar1(int star1) {
        this.star1 = star1;
    }

    public void setStar2(int star2) {
        this.star2 = star2;
    }

    public void setStar3(int star3) {
        this.star3 = star3;
    }

    public void setStar4(int star4) {
        this.star4 = star4;
    }

    public void setStar5(int star5) {
        this.star5 = star5;
    }

    public void setStar(int index, int value) {
        switch (index) {
            case 1:
                setStar1(value);
                break;
            case 2:
                setStar2(value);
                break;
            case 3:
                setStar3(value);
                break;
            case 4:
                setStar4(value);
                break;
            case 5:
                setStar5(value);
                break;
        }
    }

}
