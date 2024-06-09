package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.CoachTracking;
import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.dto.CoachTrackingDTO;
import org.example.casestudymodule4.model.dto.PlayerTrackingDTO;

import java.util.List;

public interface ICoachTrackingService {
    List<CoachTracking> findAll();
    List<CoachTracking> findAllByMonthAndYear(Integer month, Integer year);
    CoachTracking findByid(Long id);
    void save(CoachTracking coachTracking);
    void deleteById(Long id);
    List<CoachTracking> saveCoachTrackingDTO(List<CoachTrackingDTO> coachTrackingList);


}
