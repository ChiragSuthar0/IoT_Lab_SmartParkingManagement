package com.example.iotlab.Service;

import com.example.iotlab.Entity.LaneDetails;

import java.util.ArrayList;

public interface LaneDetailsService {
    int getNumberOfCarsInLaneNumber(int laneNumber);
    void increaseCarInLane(int laneNumber);
    void decreaseCarInLane(int laneNumber);
    ArrayList<LaneDetails> getCompleteStatus();
}
