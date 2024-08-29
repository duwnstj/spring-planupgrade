package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.request.ScheduleSaveRequestDto;
import com.sparta.springplanupgrade.dto.request.ScheduleUpdateRequestDto;
import com.sparta.springplanupgrade.dto.response.ScheduleDetailResponseDto;
import com.sparta.springplanupgrade.dto.response.ScheduleSaveResponseDto;
import com.sparta.springplanupgrade.dto.response.ScheduleUpdateResponseDto;
import com.sparta.springplanupgrade.service.ScheduleService;
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

    //일정 수정

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleUpdateResponseDto> upgradeSchedule(
            @PathVariable Long id, @RequestBody ScheduleUpdateRequestDto updateRequestDto) {
        ScheduleUpdateResponseDto upgradeSchedule = scheduleService.upgradeSchedule(id, updateRequestDto);
        return ResponseEntity.ok(upgradeSchedule);
    }

}
