package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Performence;
import org.example.casestudymodule4.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends CrudRepository<Player, Long> {
//    Iterable<Player> findAllByPerformence(Performence performence);
    Page<Player> findAll(Pageable pageable);
//    Page<Player> findAllByNameContainging(Pageable pageable, String name);
}
