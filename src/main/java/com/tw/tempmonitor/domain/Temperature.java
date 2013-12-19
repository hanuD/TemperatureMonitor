package com.tw.tempmonitor.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class Temperature implements Serializable{

    @Id
    private String id;

    private int rackNum;

    private int temperature;

    private Date dateTime;

    public Temperature(int rackNum, int temperature, Date dateTime) {
        this.rackNum = rackNum;
        this.temperature = temperature;
        this.dateTime = dateTime;
    }

    public Temperature() {
    }

    @Override
    public String toString() {
        return String.format( "Temperature[id=%s, rackNum='%s', temperature='%s', dateTime='%s']",
                id, rackNum, temperature, dateTime);
    }

    public String getId() {
        return id;
    }

    public int getRackNum() {
        return rackNum;
    }

    public int getTemperature() {
        return temperature;
    }

    public Date getDateTime() {
        return dateTime;
    }
}
