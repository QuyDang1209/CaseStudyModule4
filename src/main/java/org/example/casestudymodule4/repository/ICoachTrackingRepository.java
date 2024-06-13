package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Coach;
import org.example.casestudymodule4.model.CoachTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoachTrackingRepository extends JpaRepository<CoachTracking, Long> {
    List<CoachTracking> findCoachTrackingByMonthAndYear(Integer month, Integer year);
    CoachTracking findCoachTrackingByCoachAndMonthAndYear(Coach coach, Integer month, Integer year);
}
