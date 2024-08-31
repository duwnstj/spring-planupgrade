package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
