package com.jp.lms.model;

import com.jp.lms.model.enums.LeaveStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class Approvals {
    private Long id;
    private String levelName;
    private String levelWeight;
    @Enumerated(value = EnumType.ORDINAL)
    private LeaveStatus leaveStatus;
}
