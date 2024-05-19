package com.example.testdiplom.reminder;

import java.util.Date;

public class Reminder {
    private String title;
    private String periodicity;
    private Date date;
    private String time;
    private String comment;

    public Reminder(String title, String periodicity, Date date, String time, String comment) {
        this.title = title;
        this.periodicity = periodicity;
        this.date = date;
        this.time = time;
        this.comment = comment;
    }

    public Reminder(String title, String periodicity, Date date, String time) {
        this.title = title;
        this.periodicity = periodicity;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

