package com.example.iotlab.Controller;

import com.example.iotlab.Entity.LaneDetails;
import com.example.iotlab.Service.LaneDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {

    private LaneDetailsService lds;

    public UserController(LaneDetailsService laneDetailsServ) {
        this.lds = laneDetailsServ;
    }

    @GetMapping("/StatusOfAllLanes")
    public String getAllLanesStatus(Model model) {
        ArrayList<LaneDetails> all = lds.getCompleteStatus();
        model.addAttribute("Details", all);

        return "Home";
    }
}
