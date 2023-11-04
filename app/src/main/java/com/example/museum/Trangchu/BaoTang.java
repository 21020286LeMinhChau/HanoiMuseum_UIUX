package com.example.museum.Trangchu;

public class BaoTang {
    private String nameOfMuseum;
    private String address;
    private String priceOfTicket;
    private String openings;
    private String topic;
    private  int pic;

    public BaoTang(String nameOfMuseum, String address, String priceOfTicket, String openings,String topic, int pic) {
        this.nameOfMuseum = nameOfMuseum;
        this.address = address;
        this.priceOfTicket = priceOfTicket;
        this.openings = openings;
        this.topic = topic;
        this.pic = pic;
    }

    public BaoTang(String nameOfMuseum, String address, String priceOfTicket, String openings, int pic) {
        this.nameOfMuseum = nameOfMuseum;
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

    public String getPriceOfTicket() {
        return priceOfTicket;
    }

    public void setPriceOfTicket(String priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }

    public String getOpenings() {
        return openings;
    }

    public void setOpenings(String openings) {
        this.openings = openings;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
