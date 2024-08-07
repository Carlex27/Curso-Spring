package com.example.Cifrado2.repositories;

import com.example.Cifrado2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
}
