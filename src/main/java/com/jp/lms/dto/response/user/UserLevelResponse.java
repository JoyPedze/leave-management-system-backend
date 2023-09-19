package com.jp.lms.dto.response.user;

import com.jp.lms.dto.response.workflow.WorkflowDepartmentResponse;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public record UserLevelResponse(
        Long id,
        String name,
        List<WorkflowDepartmentResponse> department,
        Long weight
) {
}
