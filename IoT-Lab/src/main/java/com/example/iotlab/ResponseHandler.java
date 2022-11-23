package com.example.iotlab;

import com.example.iotlab.Entity.LaneDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateStatusResponse(String message, ArrayList<LaneDetails> all, HttpStatus status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",message);
        map.put("LaneDetails", all);

        return new ResponseEntity<Object>(map, status);
    }

}
