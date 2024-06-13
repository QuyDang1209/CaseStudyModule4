package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Player;
import org.example.casestudymodule4.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player  p where p.name like %?1%")
    List<Player> findByName(String name);

    List<Player> findPlayersByStatus(Status status);

    List<Player> findBySalaryBetween(double minSalary, double maxSalary);
}
