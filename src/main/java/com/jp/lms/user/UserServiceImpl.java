package com.jp.lms.user;

import com.jp.lms.department.DepartmentResponse;
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
                        user.getDepartments().stream().map(department -> new DepartmentResponse(
                                department.getId(),
                                department.getName(),
                                department.getShortName(),
                                department.getEmail()
                        )).collect(Collectors.toList()),
                        user.getWorkflowName()
                ))
                .collect(Collectors.toList());
    }
}
