package com.jp.lms.dto.response.workflow;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 05 September 2023
 * @Project : lms
 */
public record WorkflowDepartmentResponse(
        Long id,
        String name,
        String shortName,
        String email
) {
}
