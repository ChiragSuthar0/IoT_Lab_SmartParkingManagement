package com.example.iotlab.Controller;

import com.example.iotlab.Entity.LaneDetails;
import com.example.iotlab.Service.LaneDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class Controller {

    private LaneDetailsService lds;

    public Controller(LaneDetailsService laneDetailsServ) {
        this.lds = laneDetailsServ;
    }

    @GetMapping("/newCar/{laneNumber}")
    public void addNewCar(@PathVariable int laneNumber) {
        if (lds.getNumberOfCarsInLaneNumber(laneNumber) < 10) {
            lds.increaseCarInLane(laneNumber);
        }
    }

    @GetMapping("/removeCar/{laneNumber}")
    public void removeCar(@PathVariable int laneNumber) {
        if (lds.getNumberOfCarsInLaneNumber(laneNumber) > 0) {
            lds.decreaseCarInLane(laneNumber);
        }
    }


}