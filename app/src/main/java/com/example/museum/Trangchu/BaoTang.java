package com.example.museum.Trangchu;

import java.util.Calendar;
import java.util.List;

public class BaoTang {
    private String nameOfMuseum;
    private String address;
    private String priceOfTicket;
    private List<String> openings;
    private String opening_now;
    private String topic;
    private  String pic;


    public void preprocessingData() {
//        get today (thứ 2, thứ 3, ...)
        int day_of_week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (day_of_week) {
            case Calendar.MONDAY:
                opening_now = openings.get(0);
                break;
            case Calendar.TUESDAY:
                opening_now = openings.get(1);
                break;
            case Calendar.WEDNESDAY:
                opening_now = openings.get(2);
                break;
            case Calendar.THURSDAY:
                opening_now = openings.get(3);
                break;
            case Calendar.FRIDAY:
                opening_now = openings.get(4);
                break;
            case Calendar.SATURDAY:
                opening_now = openings.get(5);
                break;
            case Calendar.SUNDAY:
                opening_now = openings.get(6);
                break;
            default:
                opening_now = "Đang cập nhật";
                break;
        }
    }
    public BaoTang(String nameOfMuseum, String address, String priceOfTicket, List<String> openings, String topic, String pic, boolean fromDatabase) {
        this.nameOfMuseum = nameOfMuseum;
        this.address = address;
        this.priceOfTicket = priceOfTicket;
        this.openings = openings;
        this.topic = topic;
        this.pic = pic;
        if (fromDatabase) {
            preprocessingData();
        }
    }

//    public BaoTang(String nameOfMuseum, String address, String priceOfTicket, String openings,String topic, String pic) {
//        this.nameOfMuseum = nameOfMuseum;
//        this.address = address;
//        this.priceOfTicket = priceOfTicket;
//        this.openings = openings;
//        this.topic = topic;
//        this.pic = pic;
//    }
//
//    public BaoTang(String nameOfMuseum, String address, String priceOfTicket, String openings, String pic) {
//        this.nameOfMuseum = nameOfMuseum;
//        this.address = address;
//        this.priceOfTicket = priceOfTicket;
//        this.openings = openings;
//        this.pic = pic;
//    }

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

    public String getOpeningsNow() {
        return opening_now;
    }

    public void setOpeningsNow(String openingsNow) {
        this.opening_now = openingsNow;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
