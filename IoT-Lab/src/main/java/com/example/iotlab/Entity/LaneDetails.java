package com.example.iotlab.Entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LaneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int numberOfCarsInLane;
    private int laneNumber;

    public LaneDetails() {
    }

    public LaneDetails(int numberOfCarsInLane, int laneNumber) {
        this.numberOfCarsInLane = numberOfCarsInLane;
        this.laneNumber = laneNumber;
    }

    public int getNumberOfCarsInLane() {
        return numberOfCarsInLane;
    }

    public void setNumberOfCarsInLane(int numberOfCarsInLane) {
        this.numberOfCarsInLane = numberOfCarsInLane;
    }

    public int getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }
}
