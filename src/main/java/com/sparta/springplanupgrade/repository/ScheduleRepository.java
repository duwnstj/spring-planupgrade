package com.sparta.springplanupgrade.repository;

import com.sparta.springplanupgrade.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Page<Schedule> findAllOrderByUpdateAtdesc(Pageable pageable);
}
