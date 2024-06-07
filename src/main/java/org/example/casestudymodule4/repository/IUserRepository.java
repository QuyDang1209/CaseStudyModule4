package org.example.casestudymodule4.repository;

import org.example.casestudymodule4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String name);

    boolean existsByUsername(String username);

}
