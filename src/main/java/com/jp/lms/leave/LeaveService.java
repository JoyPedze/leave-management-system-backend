package com.jp.lms.leave;

import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.dto.response.leave.LeaveResponseWithStatus;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public interface LeaveService {
    RequestSuccessful applyLeave(LeaveRequest leaveRequest);

    List<LeaveResponse> getLeaves();

    //List<LeaveResponseWithStatus> getDepartmentPendingLeaves(Long userId);
}
