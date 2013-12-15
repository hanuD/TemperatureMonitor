package com.tw.tempmonitor.repository;

import com.tw.tempmonitor.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, String> {

}
