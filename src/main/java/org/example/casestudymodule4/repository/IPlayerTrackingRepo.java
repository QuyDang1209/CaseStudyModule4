package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.PlayerTracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerTrackingRepo extends CrudRepository<PlayerTracking, Long> {
}
