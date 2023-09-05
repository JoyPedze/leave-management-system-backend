package com.jp.lms.dto.response;

import com.jp.lms.dto.response.department.DepartmentResponse;
import com.jp.lms.model.Department;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public record LevelResponse(
        Long id,
        String name,
        List<DepartmentResponse> department,
        Long weight
) {
}
