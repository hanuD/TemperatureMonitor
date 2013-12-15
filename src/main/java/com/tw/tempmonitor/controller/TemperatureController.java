package main.java.com.tw.tempmonitor.controller;

import main.java.com.tw.tempmonitor.service.TemperatureMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableJpaRepositories("main.java.com.tw.tempmonitor.repository")
public class TemperatureController {

    private TemperatureMonitorService temperatureMonitorService;

    @Autowired
    public TemperatureController(TemperatureMonitorService temperatureMonitorService) {
        this.temperatureMonitorService = temperatureMonitorService;
    }

    public TemperatureController() {
    }

    @RequestMapping(value = "/temperature", method = RequestMethod.POST)
    @ResponseBody
    public void storeTemperature(@RequestParam(value="temperature") int temperature,
                               @RequestParam(value="rackNum") int rackNum,
                               @RequestParam(value="dateTime") String dateTime) {
        this.temperatureMonitorService.storeTemperature(temperature, rackNum, dateTime);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void test() {
        System.out.println("test hanu");
    }
}
