package com.blf.people.controller;
import com.blf.people.dao.CoachDao;
import com.blf.people.entity.Coach;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
@AllArgsConstructor
@Slf4j
public class CoachController {

    CoachDao coachDao;

    @GetMapping("")
    public List<Coach> getAllCoaches(){
        return coachDao.getAllCoaches();
    }

    @PostMapping("/add")
    public Coach addCoach(Coach coach){
        return coachDao.addCoach(coach);
    }

}
