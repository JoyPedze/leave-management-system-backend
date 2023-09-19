package com.jp.lms.leave;

import com.jp.lms.dto.response.leave.LeaveDepartmentResponse;
import com.jp.lms.user.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public record LeaveResponse(
        LocalDate startDate,
        LocalDate endDate,
        Long numOfDaysRequested,
        String handoverTo,
        String reason,
        String leaveType,
        String firstName,
        String lastName,
        Gender gender,
        List<LeaveDepartmentResponse> departments
) {
}
