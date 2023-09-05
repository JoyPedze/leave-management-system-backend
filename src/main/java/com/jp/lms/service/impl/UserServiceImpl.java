package com.jp.lms.service.impl;

import com.jp.lms.dto.response.LevelResponse;
import com.jp.lms.dto.response.UserResponse;
import com.jp.lms.dto.response.department.DepartmentResponse;
import com.jp.lms.dto.response.user.UserLevelResponse;
import com.jp.lms.dto.response.workflow.WorkflowDepartmentResponse;
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
                        user.getGender(),
                        user.getLevel().getName(),
                        user.getDepartment().stream().map(department -> new DepartmentResponse(
                                department.getId(),
                                department.getName(),
                                department.getShortName(),
                                department.getEmail()
                        )).collect(Collectors.toList()),
                        user.getWorkflow().getName(),
                        user.getWorkflow().getLevel().stream().map(level -> new UserLevelResponse(
                                level.getId(),
                                level.getName(),
                                level.getDepartment().stream().map(department -> new WorkflowDepartmentResponse(
                                        department.getId(),
                                        department.getName(),
                                        department.getShortName(),
                                        department.getEmail()
                                )).collect(Collectors.toList()),
                                level.getWeight()
                        )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
