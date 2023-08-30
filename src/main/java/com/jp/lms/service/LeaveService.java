package com.jp.lms.service;

import com.jp.lms.dto.payload.LeaveRequest;
import com.jp.lms.dto.response.RequestSuccessful;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
public interface LeaveService {
    RequestSuccessful applyLeave(LeaveRequest leaveRequest);
}
