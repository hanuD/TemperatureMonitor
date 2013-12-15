package com.tw.tempmonitor.domain;

import org.springframework.data.annotation.Id;

public class Temperature {

    @Id
    private String id;

    private int rackNum;

    private int temperature;

    private String dateTime;

    public Temperature(int rackNum, int temperature, String dateTime) {
        this.rackNum = rackNum;
        this.temperature = temperature;
        this.dateTime = dateTime;
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

    public String getDateTime() {
        return dateTime;
    }
}
