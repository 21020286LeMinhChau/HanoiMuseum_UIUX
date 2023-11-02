package com.example.museum;

public class ChuDe {
    private String theme;

    private  int pic;

    public ChuDe( String theme, int pic) {

        this.theme = theme;

        this.pic = pic;
    }



    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }



    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
