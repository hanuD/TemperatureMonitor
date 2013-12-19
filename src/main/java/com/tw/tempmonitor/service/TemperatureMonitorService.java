package com.tw.tempmonitor.service;

import com.tw.tempmonitor.domain.Temperature;
import com.tw.tempmonitor.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class TemperatureMonitorService {


    private TemperatureRepository repository;

    @Autowired
    public TemperatureMonitorService(TemperatureRepository temperatureRepository) {
        this.repository = temperatureRepository;
    }

    public void storeTemperature(int temperature, int rackNum) {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date currentDateTime = new Date();
        repository.save(new Temperature(rackNum, temperature, currentDateTime));
    }

    public List<Temperature> getPreviousTemperatureFromCurrentTime(int noOfRacks) {

        List<Temperature> temperatureList = new ArrayList<>();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date currentDateTime = new Date();
        for (int i = 1; i <= noOfRacks; i++) {
               temperatureList.add(repository.findOneByRackNumAndDateTimeLessThanOrderByDateTimeDesc(i, currentDateTime));
        }
        return temperatureList;
    }
}
