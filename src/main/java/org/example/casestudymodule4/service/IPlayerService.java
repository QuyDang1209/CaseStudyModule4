package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.DTO.PlayerStatusDTO;
import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.DTO.PlayerDTO;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findByid(Long id);
    void save(Player player);
    void deleteById(Long id);

//    void deleteAllByID(List<Player> players);
    Player savePlayerDTO(PlayerDTO playerDTO);
    void changeStatus(List<PlayerStatusDTO> playerStatusDTOS);
}
