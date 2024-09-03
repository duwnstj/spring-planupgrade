package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.manager.request.ManagerSaveRequestDto;
import com.sparta.springplanupgrade.dto.manager.response.ManagerSaveResponseDto;
import com.sparta.springplanupgrade.dto.manager.response.ManagerSimpleResponseDto;
import com.sparta.springplanupgrade.dto.user.UserDto;
import com.sparta.springplanupgrade.entity.Manager;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.entity.User;
import com.sparta.springplanupgrade.repository.ManagerRepository;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import com.sparta.springplanupgrade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ManagerSaveResponseDto saveManager(ManagerSaveRequestDto managerSaveRequestDto) {

        //일정이 실제로 있는 일정인지 확인
        Schedule schedule = scheduleRepository.findById(managerSaveRequestDto.getScheduleId())
                .orElseThrow(() -> new NullPointerException("schedule not found"));

        // 등록하려는 유저가 일정을 만든 사람인지 확인 후 가져온다.
        User scheduleUser = userRepository.findById(managerSaveRequestDto.getScheduleUserId())
                .orElseThrow(() -> new NullPointerException("일정을 만든 유저가 아닙니다."));

        //등록하려고하는 담당자가 실제로 존재하는 유저인지 확인하고 가져온다.
        User manager = userRepository.findById(managerSaveRequestDto.getManagerUserId())
                .orElseThrow(() -> new NullPointerException("User not found"));
        Manager newManager = new Manager(manager, schedule);
        Manager saveManager = managerRepository.save(newManager);

        return new ManagerSaveResponseDto(saveManager.getId());
    }

    public List<ManagerSimpleResponseDto> getMembers(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("schedule not found"));

        List<Manager> managerList = managerRepository.findByScheduleId(schedule.getId());

        List<ManagerSimpleResponseDto> dtoList = new ArrayList<>();

        for (Manager manager : managerList) {
            User user = manager.getUser();
            dtoList.add(new ManagerSimpleResponseDto(

                    manager.getId(),
                    new UserDto(user.getId(), user.getUserName(), user.getEmail())
            ));
        }

        return dtoList;
    }
}
