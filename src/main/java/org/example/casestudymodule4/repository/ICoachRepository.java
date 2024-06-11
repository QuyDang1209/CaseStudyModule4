package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Long> {
    @Query("select c from Coach  c where c.name like %?1%")
    List<Coach> findByName(String name);
}
