package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.ScheduleRequestDto;
import com.sparta.springplanupgrade.dto.ScheduleResponseDto;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;


    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
        ScheduleResponseDto savedSchedule = scheduleService.saveSchedule(scheduleRequestDto);
        return ResponseEntity.ok(savedSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id){
        ScheduleResponseDto getSchedule = scheduleService.getSchedule(id);
        return ResponseEntity.ok(getSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> upgradeSchedule(
            @PathVariable Long id , @RequestBody ScheduleRequestDto scheduleRequestDto){
        ScheduleResponseDto upgradeSchedule = scheduleService.upgradeSchedule(id,scheduleRequestDto);
        return ResponseEntity.ok(upgradeSchedule);
    }

}
