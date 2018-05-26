package com.example.demo4.domain;

import java.io.Serializable;
import java.util.Date;

public class TicketsBean  implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String train;

    private Date start_date;

    private String start_airport;

    private Date end_date;

    private String end_airport;

    private int price;

    private String airline;

    private String start_date_string;

    private String end_date_string;

    public String getEnd_date_string() {
        return end_date_string;
    }

    public void setEnd_date_string(String end_date_string) {
        this.end_date_string = end_date_string;
    }

    public String getStart_date_string() {
        return start_date_string;
    }

    public void setStart_date_string(String start_date_string) {
        this.start_date_string = start_date_string;
    }

    public int getId() {
        return id;
    }

    public String getTrain() {
        return train;
    }

    public Date getStart_date() {
        return start_date;
    }

    public String getStart_airport() {
        return start_airport;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public String getEnd_airport() {
        return end_airport;
    }

    public int getPrice() {
        return price;
    }

    public String getAirline() {
        return airline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setStart_airport(String start_airport) {
        this.start_airport = start_airport;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setEnd_airport(String end_airport) {
        this.end_airport = end_airport;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
