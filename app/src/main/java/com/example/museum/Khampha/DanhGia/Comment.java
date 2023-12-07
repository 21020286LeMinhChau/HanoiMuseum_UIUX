package com.example.museum.Khampha.DanhGia;

import com.google.api.client.util.DateTime;

import org.json.JSONException;
import org.json.JSONObject;

public class Comment {
    private String user;
    private String comment;
    private int vote;
    private DateTime dateTime;
    private String timePrint;
    private long timeInt;


    public String processTime(DateTime dateTime) {
//         if comment < 1 min -> vừa xong
//         if comment < 1 hour -> x phút trước
//         if comment < 1 day -> x giờ trước
//         if comment < 1 week -> x ngày trước
//         if comment < 1 month -> x tuần trước
//         if comment < 1 year -> x tháng trước
//         else -> x năm trước
//        datetime: 2020-11-11T10:00:00.000+07:00

        DateTime now = new DateTime(System.currentTimeMillis());
        long time = (now.getValue() - dateTime.getValue()) / 1000;


        timeInt = time;

        if (time < 60) {
            return "Vừa xong";
        } else if (time < 3600) {
            return time / 60 + " phút trước";
        } else if (time < 86400) {
            return time / 3600 + " giờ trước";
        } else if (time < 604800) {
            return time / 86400 + " ngày trước";
        } else if (time < 2592000) {
            return time / 604800 + " tuần trước";
        } else if (time < 31536000) {
            return time / 2592000 + " tháng trước";
        } else {
            return time / 31536000 + " năm trước";
        }
    }

    public Comment(String user, String comment, DateTime time_comment, int vote) throws JSONException {
        this.user = user;
        this.comment = comment;
        this.vote = vote;
        this.dateTime = time_comment;
        this.timePrint = processTime(dateTime);
    }


    public int getVote() {
        return vote;
    }

    public String getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public String getTimePrint() {
        return timePrint;
    }

    public long getTimeInt() {
        return timeInt;
    }

}
