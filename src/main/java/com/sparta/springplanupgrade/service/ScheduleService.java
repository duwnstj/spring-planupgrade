package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.request.ScheduleSaveRequestDto;
import com.sparta.springplanupgrade.dto.request.ScheduleUpdateRequestDto;
import com.sparta.springplanupgrade.dto.response.ScheduleDetailResponseDto;
import com.sparta.springplanupgrade.dto.response.ScheduleSaveResponseDto;
import com.sparta.springplanupgrade.dto.response.ScheduleUpdateResponseDto;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 저장
    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponseDto(savedSchedule);
//        Manager manager = managerService.getManagerEntity(request.getManagerId());
//        return TodoResponse.of(todoRepository.save(entity));
    }

    // 일정 단건 조회
    public ScheduleDetailResponseDto getSchedule(Long id) {
        Schedule getSchedule = scheduleRepository.findById(id).orElseThrow();
        return new ScheduleDetailResponseDto(
                getSchedule.getId(),
                getSchedule.getTitle(),
                getSchedule.getUserName(),
                getSchedule.getContent()
        );
    }


    //일정 수정
    @Transactional
    public ScheduleUpdateResponseDto upgradeSchedule(Long id, ScheduleUpdateRequestDto updateRequestDto) {
        Schedule getSchedule = scheduleRepository.findById(id).orElseThrow(() ->
                new NullPointerException("아이디를 찾을 수 없습니다."));
        getSchedule.update(
                updateRequestDto.getContent(),
                updateRequestDto.getTitle(),
                updateRequestDto.getUserName()
        );
        return new ScheduleUpdateResponseDto(getSchedule.getId());
    }
}
