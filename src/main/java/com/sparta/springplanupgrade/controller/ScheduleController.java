package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.springplanupgrade.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleDetailResponseDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleSimpleResponstDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.springplanupgrade.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController

@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;


    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 저장

    @PostMapping
    public ResponseEntity<ScheduleSaveResponseDto> createSchedule(@RequestBody ScheduleSaveRequestDto scheduleRequestDto) {
        ScheduleSaveResponseDto savedSchedule = scheduleService.saveSchedule(scheduleRequestDto);
        URI location = URI.create("/api/schedules/" + savedSchedule.getId());
        return ResponseEntity.created(location).body(savedSchedule);
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDetailResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleDetailResponseDto getSchedule = scheduleService.getSchedule(id);
        return ResponseEntity.ok(getSchedule);
    }

    // 일정 전체 조회
    @GetMapping("/schedules")
    public Page<ScheduleSimpleResponstDto> getSchedules(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return scheduleService.getSchedules(page, size);
    }

    //일정 수정

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleUpdateResponseDto> upgradeSchedule(
            @PathVariable Long id, @RequestBody ScheduleUpdateRequestDto updateRequestDto) {
        ScheduleUpdateResponseDto upgradeSchedule = scheduleService.upgradeSchedule(id, updateRequestDto);
        return ResponseEntity.ok(upgradeSchedule);
    }

}
