package com.jp.lms.dto.response.leave;

import java.time.LocalDate;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public record PendingLeaveResponse(
        LocalDate startDate,
        LocalDate endDate,
        Long numOfDaysRequested,
        String handoverTo,
        String reason,
        String leaveType
) {
}
