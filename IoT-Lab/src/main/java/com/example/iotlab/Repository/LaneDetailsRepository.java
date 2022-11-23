package com.example.iotlab.Repository;

import com.example.iotlab.Entity.LaneDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LaneDetailsRepository extends JpaRepository<LaneDetails, Long> {

    LaneDetails getLaneDetailsByLaneNumber(int laneNumber);

}
