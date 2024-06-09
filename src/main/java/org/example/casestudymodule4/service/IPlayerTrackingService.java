package org.example.casestudymodule4.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.PlayerTracking;
import org.example.casestudymodule4.model.dto.PlayerTrackingDTO;

import java.util.List;

public interface IPlayerTrackingService {
    List<PlayerTracking> findAll();
    List<PlayerTracking> findAllByMonthAndYear(Integer month, Integer year);
    PlayerTracking findByid(Long id);
    void save(PlayerTracking playerTracking);
    void deleteById(Long id);

    List<PlayerTracking> savePlayerTrackingDTO(List<PlayerTrackingDTO> playerTrackingDTO);
}
