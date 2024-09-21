package com.smartoffice.repository;

import com.smartoffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query to find a user by username
    Optional<User> findByUsername(String username);

    // Custom query to find a user by email
    Optional<User> findByEmail(String email);

}
