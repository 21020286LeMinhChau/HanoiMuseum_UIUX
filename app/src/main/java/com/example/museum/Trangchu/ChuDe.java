package com.example.museum.Trangchu;

public class ChuDe {
    private String theme;

//    private  int pic;
    private String picture;

//    public ChuDe( String theme, int pic) {
//
//        this.theme = theme;
//
//        this.pic = pic;
//    }

    public ChuDe(String theme, String picture) {
        this.theme = theme;
        this.picture = picture;
    }




    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }



//    public int getPic() {
//        return pic;
//    }

    public String getPicture() {
        return picture;
    }

//    public void setPic(int pic) {
//        this.pic = pic;
//    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
