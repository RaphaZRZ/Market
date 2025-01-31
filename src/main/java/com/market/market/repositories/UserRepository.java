package com.market.market.repositories;

import com.market.market.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByCPF(String CPF);
    Optional<User> findByEmail(String email);
}
