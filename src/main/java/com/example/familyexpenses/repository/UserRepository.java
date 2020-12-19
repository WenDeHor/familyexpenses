package com.example.familyexpenses.repository;

import com.example.familyexpenses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
Optional<User>findOneByEmail(String email);
}
