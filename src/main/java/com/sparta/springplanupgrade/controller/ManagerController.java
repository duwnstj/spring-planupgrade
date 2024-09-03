package com.sparta.springplanupgrade.controller;

import com.sparta.springplanupgrade.dto.manager.request.ManagerSaveRequestDto;
import com.sparta.springplanupgrade.dto.manager.response.ManagerSaveResponseDto;
import com.sparta.springplanupgrade.dto.manager.response.ManagerSimpleResponseDto;
import com.sparta.springplanupgrade.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/schedules/managers")
    private ResponseEntity<ManagerSaveResponseDto> saveManager(@RequestBody ManagerSaveRequestDto managerSaveRequestDto) {
        return ResponseEntity.ok(managerService.saveManager(managerSaveRequestDto));

    }

    @GetMapping("schedules/{scheduleId}/managers")
    private ResponseEntity<List<ManagerSimpleResponseDto>> getMembers(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(managerService.getMembers(scheduleId));
    }
}
