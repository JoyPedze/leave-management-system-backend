package com.jp.lms.service.impl;

import com.jp.lms.dto.response.UserResponse;
import com.jp.lms.repository.UserRepository;
import com.jp.lms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<UserResponse> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getStaffPosition(),
                        user.getDepartment(),
                        user.getGender(),
                        user.getWorkflow().getName(),
                        user.getWorkflow().getLevel()
                ))
                .collect(Collectors.toList());
    }
}
