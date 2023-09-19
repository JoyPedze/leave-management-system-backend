package com.jp.lms.leave;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Data
public class LeaveRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private String handoverTo;
    private String reason;
    private String leaveType;
    private Long userId;
}
