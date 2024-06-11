package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
