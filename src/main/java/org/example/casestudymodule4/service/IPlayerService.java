package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.DTO.PlayerStatusDTO;
import org.example.casestudymodule4.model.Player;

import org.example.casestudymodule4.model.DTO.PlayerDTO;

import org.example.casestudymodule4.model.Status;


import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findByid(Long id);
    void save(Player player);
    void deleteById(Long id);

    Player savePlayerDTO(PlayerDTO playerDTO);

    void changeStatus(List<PlayerStatusDTO> playerStatusDTOS);


    List<Player> findPlayersByName(String name);

    List<Player> findPlayersByStatus(Status status);


}
