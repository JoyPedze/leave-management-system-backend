package com.jp.lms.dto.response.workflow;

import com.jp.lms.dto.response.workflow.WorkflowLevelResponse;
import com.jp.lms.user.User;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public record WorkflowResponse(
        Long id,
        String name,
        List<User> users
) {
}
