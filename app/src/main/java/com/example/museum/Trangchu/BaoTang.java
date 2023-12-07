package com.example.museum.Trangchu;

import java.util.Calendar;
import java.util.List;

public class BaoTang {
    private String nameOfMuseum;
    private String address;
    private String priceOfTicket;
    List<String> priceOfTicketFree;
    List<String> priceOfTicketNotFree;
    private List<String> openings;
    private String opening_now;
    private List<String> topic;
    private String pic;
    private double x_toado;
    private double y_toado;
    private int comment;
    private double vote;
    private String gioi_thieu;

    private int anh;

    public void preprocessingDay() {
        // get today (thứ 2, thứ 3, ...)
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

    public BaoTang(String nameOfMuseum, String address, String priceOfTicket,List<String>priceOfTicketFree,List<String>priceOfTicketNotFree, List<String> openings, List<String> topic,
                   String pic, String gioi_thieu, double x_toado, double y_toado, int comment, boolean fromDatabase) {
        this.nameOfMuseum = nameOfMuseum;
        this.address = address;
        this.priceOfTicket = priceOfTicket;
        this.openings = openings;
        this.topic = topic;
        this.pic = pic;
        this.gioi_thieu = gioi_thieu;
        this.x_toado = x_toado;
        this.y_toado = y_toado;
        this.comment = comment;
        this.priceOfTicketFree = priceOfTicketFree;
        this.priceOfTicketNotFree = priceOfTicketNotFree;
        if (openings != null) {
            preprocessingDay();
        }
    }

    public List<String> getTopic() {
        return topic;
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

    public int getComment() {
        return comment;
    }

    public double getVote() {
        return vote;
    }

    public String getGioiThieu() {
        return gioi_thieu;
    }

    public List<String> getPriceFree() {
        return priceOfTicketFree;
    }

    public List<String> getPriceNotFree() {
        return priceOfTicketNotFree;
    }

    public List<String> getOpeningTime() {
        return openings;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String diadiem;
    private String status;

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public double getX_toado() {
        return x_toado;
    }

    public double getY_toado() {
        return y_toado;
    }
}
