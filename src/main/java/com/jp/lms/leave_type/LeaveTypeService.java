package com.jp.lms.leave_type;

import com.jp.lms.dto.response.RequestSuccessful;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public interface LeaveTypeService {
    List<LeaveTypeResponse> getLeaveTypes();

    RequestSuccessful saveLeaveType(LeaveTypeRequest leaveTypeRequest);
}
