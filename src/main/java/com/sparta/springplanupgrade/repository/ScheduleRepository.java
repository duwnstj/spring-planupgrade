package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule , Long > {
}
