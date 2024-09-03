package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    boolean existsByScheduleIdAndUserId(Long scheduleId, Long managerUserId);

    List<Manager> findByScheduleId(Long id);
}
