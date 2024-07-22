package com.example.JwtAuthentication.repository;

import com.example.JwtAuthentication.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OurUsersRepo extends JpaRepository<OurUsers, Long> {
    Optional<OurUsers> findByEmail(String email);
}
