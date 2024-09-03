package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.user.request.UserSaveRequestDto;
import com.sparta.springplanupgrade.dto.user.response.UserDetailResponseDto;
import com.sparta.springplanupgrade.dto.user.response.UserSaveResponseDto;
import com.sparta.springplanupgrade.dto.user.response.UserSimpleResponseDto;
import com.sparta.springplanupgrade.entity.User;
import com.sparta.springplanupgrade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    //  유저 저장
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {
        User newUser = new User(
                userSaveRequestDto.getUserName(),
                userSaveRequestDto.getEmail()
        );
        User saveUser = userRepository.save(newUser);

        return new UserSaveResponseDto(
                saveUser.getId(),
                saveUser.getUserName(),
                saveUser.getEmail()
        );
    }

    public List<UserSimpleResponseDto> getUsers() {

        List<User> getList = userRepository.findAll();

        List<UserSimpleResponseDto> doList = new ArrayList<>();

        for (User user : getList) {
            doList.add(new UserSimpleResponseDto(
                    user.getId(),
                    user.getUserName()
            ));
        }
        return doList;
    }

    public UserDetailResponseDto getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NullPointerException("User를 찾을 수 없습니다."));

        return new UserDetailResponseDto(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NullPointerException("user를 찾을 수 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
