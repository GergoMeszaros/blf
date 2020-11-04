package com.blf.people.daodb;

import com.blf.people.dao.CoachDao;
import com.blf.people.entity.Coach;
import com.blf.people.repository.CoachRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CoachDaoDB implements CoachDao {

    CoachRepository coachRepository;

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach getCoachById(Long coachId) {
        return coachRepository.findById(coachId).orElse(null);
    }

    @Override
    public Coach addCoach(Coach coach) {
        return coachRepository.saveAndFlush(coach);
    }

    @Override
    public Coach updateCoach(Long coachId, Coach updatedCoach) {
        Coach coachToUpdate = coachRepository.findById(coachId).orElse(null);

        if (coachToUpdate != null) {
            coachToUpdate.setName(updatedCoach.getName());
            coachToUpdate.setEmail(updatedCoach.getEmail());
            coachToUpdate.setPhoneNumber(updatedCoach.getPhoneNumber());
            coachToUpdate.setPhotoRoot(updatedCoach.getPhotoRoot());
            coachToUpdate.setTitle(updatedCoach.getTitle());

            coachRepository.saveAndFlush(coachToUpdate);
            log.info("Updated Coach: " + coachToUpdate);
        } else {
            log.info("Coach not found with the following id: " + coachId);
        }
        return coachToUpdate;
    }

    @Override
    public Coach deleteCoach(Long coachId) {
        Coach coachToDelete = coachRepository.findById(coachId).orElse(null);
        coachRepository.deleteById(coachId);

        log.info("Deleted Coach: " + coachToDelete);
        return coachToDelete;
    }
}
