package com.example.iotlab.Service.Impl;

import com.example.iotlab.Entity.LaneDetails;
import com.example.iotlab.Repository.LaneDetailsRepository;
import com.example.iotlab.Service.LaneDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaneDetailsServiceImpl implements LaneDetailsService {

    private LaneDetailsRepository laneDetailsRepo;

    public LaneDetailsServiceImpl(LaneDetailsRepository laneDetailsRepo) {
        super();
        this.laneDetailsRepo = laneDetailsRepo;
    }

    @Override
    public int getNumberOfCarsInLaneNumber(int laneNumber) {
        return laneDetailsRepo.getLaneDetailsByLaneNumber(laneNumber).getNumberOfCarsInLane();
    }

    @Override
    public void increaseCarInLane(int laneNumber) {
        LaneDetails ld = laneDetailsRepo.getLaneDetailsByLaneNumber(laneNumber);
        int carNumber = ld.getNumberOfCarsInLane();
        ld.setNumberOfCarsInLane(carNumber+1);
        laneDetailsRepo.save(ld);
    }

    public void decreaseCarInLane(int laneNumber) {
        LaneDetails ld = laneDetailsRepo.getLaneDetailsByLaneNumber(laneNumber);
        int carNumber = ld.getNumberOfCarsInLane();
        ld.setNumberOfCarsInLane(carNumber-1);
        laneDetailsRepo.save(ld);
    }

    public ArrayList<LaneDetails> getCompleteStatus() {
        ArrayList<LaneDetails> all = (ArrayList<LaneDetails>) laneDetailsRepo.findAll();
        return all;
    }
}
