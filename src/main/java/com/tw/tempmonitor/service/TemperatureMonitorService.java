package main.java.com.tw.tempmonitor.service;

import main.java.com.tw.tempmonitor.domain.Temperature;
import main.java.com.tw.tempmonitor.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureMonitorService {


    private TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureMonitorService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public void storeTemperature(int temperature, int rackNum, String dateTime) {
        temperatureRepository.save(new Temperature(rackNum, temperature, dateTime));
    }
}
