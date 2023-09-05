package com.jp.lms.dto.response;

import com.jp.lms.model.Department;
import com.jp.lms.model.Level;
import com.jp.lms.model.enums.Gender;

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
        String level,
        List<Department> department,
        String workflowName,
        List<Level> levels
) {
}
