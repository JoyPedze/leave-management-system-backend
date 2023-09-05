package com.jp.lms.dto.response;

import com.jp.lms.dto.response.leave.LeaveDepartmentResponse;
import com.jp.lms.model.Department;
import com.jp.lms.model.LeaveType;
import com.jp.lms.model.User;
import com.jp.lms.model.enums.Gender;

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
