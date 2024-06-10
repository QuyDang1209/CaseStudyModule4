package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long>, JpaSpecificationExecutor<Player> {
//    List<Player> deleteAllPlayerById(List<Long> id);
List<Player> findBySalaryBetween(double minSalary, double maxSalary);
}
