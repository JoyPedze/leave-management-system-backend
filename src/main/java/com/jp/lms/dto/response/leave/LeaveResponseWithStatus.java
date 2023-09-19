package com.jp.lms.dto.response.leave;

import com.jp.lms.leave.LeaveStatus;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public record LeaveResponseWithStatus(
        List<PendingLeaveResponseWithUser> pendingLeaveResponseWithUser,
        LeaveStatus leaveStatus
) {
}
