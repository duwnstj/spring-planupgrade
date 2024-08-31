package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.springplanupgrade.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleDetailResponseDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.springplanupgrade.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.springplanupgrade.dto.user.UserDto;
import com.sparta.springplanupgrade.entity.Schedule;
import com.sparta.springplanupgrade.entity.User;
import com.sparta.springplanupgrade.repository.ScheduleRepository;
import com.sparta.springplanupgrade.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {

        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    // 일정 저장
    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto scheduleRequestDto) {

        User user = userRepository.findById(scheduleRequestDto.getUserId())
                .orElseThrow(() -> new NullPointerException("User not found"));

        Schedule newSchedule = new Schedule(
                scheduleRequestDto.getContent(),
                scheduleRequestDto.getTitle(),
                user
        );
        Schedule saveSchedule = scheduleRepository.save(newSchedule);

        return new ScheduleSaveResponseDto(
                saveSchedule.getId(),
                saveSchedule.getUser(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getCreateAt(),
                saveSchedule.getUpdateAt()
        );


    }

    // 일정 단건 조회
    public ScheduleDetailResponseDto getSchedule(Long id) {
        Schedule getSchedule = scheduleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재 하지 않습니다."));

        User user = getSchedule.getUser();
        return new ScheduleDetailResponseDto(

                getSchedule.getId(),
                getSchedule.getTitle(),
                new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                getSchedule.getContent(),
                getSchedule.getCreateAt(),
                getSchedule.getUpdateAt(),
                getSchedule.getComments().size()
        );

    }

    public Page<ScheduleDetailResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Schedule> schedules = scheduleRepository.findAllByOrderByUpdateAtDesc(pageable);

        return schedules.map(schedule -> {
            User user = schedule.getUser();
            return new ScheduleDetailResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    new UserDto(user.getId(), user.getUserName(), user.getEmail()),
                    schedule.getContent(),
                    schedule.getCreateAt(),
                    schedule.getUpdateAt(),
                    schedule.getComments().size()
            );

        });
    }


    //일정 수정
    @Transactional
    public ScheduleUpdateResponseDto upgradeSchedule(Long id, ScheduleUpdateRequestDto updateRequestDto) {
        Schedule getSchedule = scheduleRepository.findById(id).orElseThrow(() ->
                new NullPointerException("아이디를 찾을 수 없습니다."));
        
        getSchedule.update(
                updateRequestDto.getTitle(),
                updateRequestDto.getContent()
        );
        return new ScheduleUpdateResponseDto(getSchedule.getId());
    }


    //일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {

        scheduleRepository.deleteById(id);
    }
}
