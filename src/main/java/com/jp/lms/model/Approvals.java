package com.jp.lms.model;

import com.jp.lms.model.enums.LeaveStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

public class Approvals {
    private Long id;
    private String levelName;
    private String levelWeight;
    @Enumerated(value = EnumType.ORDINAL)
    private LeaveStatus leaveStatus;
}
