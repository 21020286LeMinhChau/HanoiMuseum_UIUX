package com.example.museum;

import java.io.Serializable;

public class ItemsDomain implements Serializable {
    private String nameOfMuseum;
    private String theme;
    private String address;
    private int priceOfTicket;
    private String openings;
    private  String pic;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public ItemsDomain(String nameOfMuseum, String address, String theme, int priceOfTicket, String openings, String pic) {
        this.nameOfMuseum = nameOfMuseum;
        this.theme = theme;
        this.address = address;
        this.priceOfTicket = priceOfTicket;
        this.openings = openings;
        this.pic = pic;
    }

    public String getNameOfMuseum() {
        return nameOfMuseum;
    }

    public void setNameOfMuseum(String nameOfMuseum) {
        this.nameOfMuseum = nameOfMuseum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriceOfTicket() {
        return priceOfTicket;
    }

    public void setPriceOfTicket(int priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }

    public String getOpenings() {
        return openings;
    }

    public void setOpenings(String openings) {
        this.openings = openings;
    }
}
