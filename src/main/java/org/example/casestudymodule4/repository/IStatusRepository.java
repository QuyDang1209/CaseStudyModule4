package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends CrudRepository<Status, Long> {
}
