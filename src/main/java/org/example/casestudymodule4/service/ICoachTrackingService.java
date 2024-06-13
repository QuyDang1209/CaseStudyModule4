package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.CoachTracking;
import org.example.casestudymodule4.model.DTO.CoachTrackingDTO;

import java.util.List;

public interface ICoachTrackingService {
    List<CoachTracking> findAll();
    List<CoachTracking> findAllByMonthAndYear(Integer month, Integer year);
    List<CoachTracking> findCoachTrackingByIdAndMonthAndYear(Long id, Integer month, Integer year);
    CoachTracking findByid(Long id);
    void save(CoachTracking coachTracking);
    void deleteById(Long id);
    List<CoachTracking> saveCoachTrackingDTO(List<CoachTrackingDTO> coachTrackingList);


}
