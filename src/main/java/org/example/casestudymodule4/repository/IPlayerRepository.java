package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {
//    List<Player> deleteAllPlayerById(List<Long> id);
}
