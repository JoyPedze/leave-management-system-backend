package com.jp.lms.user;

import com.jp.lms.department.DepartmentResponse;
import com.jp.lms.dto.response.user.UserLevelResponse;
import com.jp.lms.user.Gender;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */
public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String staffPosition,
        Gender gender,
        List<DepartmentResponse> department,
        String workflowName
) {
}
