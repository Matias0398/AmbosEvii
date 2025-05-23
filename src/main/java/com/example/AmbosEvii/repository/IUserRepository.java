package com.example.AmbosEvii.repository;

import com.example.AmbosEvii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String userName);
}
