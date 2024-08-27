package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.ScheduleRequestDto;
import com.sparta.springplanupgrade.dto.ScheduleResponseDto;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
       Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
//        Manager manager = managerService.getManagerEntity(request.getManagerId());
//        return TodoResponse.of(todoRepository.save(entity));
    }

    public ScheduleResponseDto getSchedule(Long id) {
       Schedule getSchedule = scheduleRepository.findById(id).orElseThrow();
        return new ScheduleResponseDto(getSchedule);
    }

    public ScheduleResponseDto upgradeSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule getSchedule = scheduleRepository.findById(id).orElseThrow();

        getSchedule.setUserName(scheduleRequestDto.getUserName());
        getSchedule.setContent(scheduleRequestDto.getContent());
        getSchedule.setTitle(scheduleRequestDto.getTitle());
        scheduleRepository.save(getSchedule);

        return new ScheduleResponseDto(getSchedule);
    }
}
