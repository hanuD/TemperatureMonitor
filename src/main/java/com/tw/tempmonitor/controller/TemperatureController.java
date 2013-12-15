package com.tw.tempmonitor.controller;

import com.tw.tempmonitor.service.TemperatureMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TemperatureController {

    private TemperatureMonitorService temperatureMonitorService;

    @Autowired
    public TemperatureController(TemperatureMonitorService temperatureMonitorService) {
        this.temperatureMonitorService = temperatureMonitorService;
    }

    public TemperatureController() {
    }

    @RequestMapping(value = "/storeTemperature", method = RequestMethod.POST)
    @ResponseBody
    public void storeTemperature(@RequestParam(value = "temperature") String temperature,
                               @RequestParam(value = "rackNum") String rackNum,
                               @RequestParam(value = "dateTime") String dateTime) {

        this.temperatureMonitorService.storeTemperature(Integer.parseInt(temperature), Integer.parseInt(rackNum), dateTime);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "hello";
    }
}
