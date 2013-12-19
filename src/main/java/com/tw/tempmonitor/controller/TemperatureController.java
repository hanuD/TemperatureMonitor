package com.tw.tempmonitor.controller;

import com.tw.tempmonitor.domain.Temperature;
import com.tw.tempmonitor.service.TemperatureMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TemperatureController {

    private TemperatureMonitorService temperatureMonitorService;

    @Autowired
    public TemperatureController(TemperatureMonitorService temperatureMonitorService) {
        this.temperatureMonitorService = temperatureMonitorService;
    }

    public TemperatureController() {
    }

    @RequestMapping(value = "/storeTemperature/{rackNum}/{temperature}", method = RequestMethod.GET)
    @ResponseBody
    public void storeTemperature(@PathVariable String rackNum,
                               @PathVariable String temperature) {

        this.temperatureMonitorService.storeTemperature(Integer.parseInt(temperature), Integer.parseInt(rackNum));
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "/getTemperature/{noOfRacks}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Temperature> getTemperature(@PathVariable String noOfRacks) {
        List<Temperature> temperatureList = this.temperatureMonitorService.getPreviousTemperatureFromCurrentTime(Integer.parseInt(noOfRacks));
        return temperatureList;
    }
}
