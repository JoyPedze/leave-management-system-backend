package com.jp.lms.dto.response.leave;

import com.jp.lms.model.enums.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 05 September 2023
 * @Project : lms
 */
public record PendingLeaveResponseWithUser(
        List<PendingLeaveResponse> pendingLeaveResponse,
        String firstName,
        String lastName,
        Gender gender,
        List<LeaveDepartmentResponse> departments
) {
}
