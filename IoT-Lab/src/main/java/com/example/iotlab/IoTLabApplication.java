package com.example.iotlab;

import com.example.iotlab.Entity.LaneDetails;
import com.example.iotlab.Repository.LaneDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IoTLabApplication implements ApplicationRunner {

    @Autowired
    private LaneDetailsRepository laneRepo;

    public static void main(String[] args) {
        SpringApplication.run(IoTLabApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        laneRepo.deleteAll();

        LaneDetails ld = new LaneDetails(0, 1);
        LaneDetails ld1 = new LaneDetails(0, 2);
        LaneDetails ld2 = new LaneDetails(0, 3);

        laneRepo.save(ld);
        laneRepo.save(ld1);
        laneRepo.save(ld2);
    }
}
