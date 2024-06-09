package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.PlayerTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IPlayerTrackingRepository extends JpaRepository<PlayerTracking, Long> {
    List<PlayerTracking> findPlayerTrackingByMonthAndYear(Integer month, Integer year);

}
