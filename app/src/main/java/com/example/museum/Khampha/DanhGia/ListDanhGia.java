package com.example.museum.Khampha.DanhGia;

public class ListDanhGia {
    private String tenNguoiDanhGia;
    private String noiDungDanhGia;
    private int soSao;
    private String thoiGianDanhGia;
    private int avatar;
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

}
