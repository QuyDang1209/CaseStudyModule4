package org.example.casestudymodule4.service;

import org.example.casestudymodule4.model.Performence;
import org.example.casestudymodule4.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlayerService extends IGenerateService<Player> {
//    Iterable<Player> findAllByPerformence(Performence performence);
    Page<Player> findAll(Pageable pageable);
//    Page<Player> findAllByNameContainging(Pageable pageable, String name);
}
