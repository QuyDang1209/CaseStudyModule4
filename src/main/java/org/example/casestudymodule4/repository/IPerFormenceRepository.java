package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Performence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerFormenceRepository  extends JpaRepository<Performence, Long> {
}
