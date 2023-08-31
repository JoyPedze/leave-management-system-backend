package com.jp.lms.dto.response;

import com.jp.lms.model.LeaveType;
import com.jp.lms.model.User;

import java.time.LocalDate;

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
        LeaveType leaveType,
        User user
) {
}
