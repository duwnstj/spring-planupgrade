package com.sparta.springplanupgrade.service;

import com.sparta.springplanupgrade.dto.user.request.UserSaveRequestDto;
import com.sparta.springplanupgrade.dto.user.response.UserSaveResponseDto;
import com.sparta.springplanupgrade.entity.User;
import com.sparta.springplanupgrade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
