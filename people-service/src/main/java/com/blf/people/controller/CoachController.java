package com.blf.people.controller;
import com.blf.people.dao.CoachDao;
import com.blf.people.entity.Coach;
import com.blf.people.repository.CoachRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public Coach addCoach(@RequestBody Coach coach){
        return coachDao.addCoach(coach);
    }

    @PutMapping("/update/{coachId}")
    public Coach updateCoach(@PathVariable Long coachId, @RequestBody Coach coach){
        return coachDao.updateCoach(coachId,coach);
    }

    @DeleteMapping("/delete/{coachId}")
    public Coach deleteCoach(@PathVariable Long coachId){
        return coachDao.deleteCoach(coachId);
    }


}
