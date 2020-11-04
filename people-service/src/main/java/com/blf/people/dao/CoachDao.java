package com.blf.people.dao;
import com.blf.people.entity.Coach;
import java.util.List;

public interface CoachDao {

    List<Coach> getAllCoaches();

    Coach getCoachById(Long coachId);

    Coach addCoach(Coach coach);

    Coach updateCoach(Long id, Coach coach);

    Coach deleteCoach(Long id);

}
