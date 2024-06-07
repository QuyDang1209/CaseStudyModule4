package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoachRepository extends JpaRepository<Coach, Long> {
}
