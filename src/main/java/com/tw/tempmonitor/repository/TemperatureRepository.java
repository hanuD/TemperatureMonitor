package main.java.com.tw.tempmonitor.repository;

import main.java.com.tw.tempmonitor.domain.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface TemperatureRepository extends MongoRep`ository<Temperature, String> {


}
