package com.tw.tempmonitor.repository;

import com.tw.tempmonitor.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, String> {
       Temperature findOneByDateTimeLessThanOrderByDateTimeAsc(Date date, int rackNum);

       Temperature findOneByRackNumAndDateTimeLessThanOrderByDateTimeDesc(int rackNum, Date date);
}
