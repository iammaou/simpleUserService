package com.example.userService.repository;

import com.example.userService.model.Postal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalRepository extends JpaRepository<Postal, Long> {
}
