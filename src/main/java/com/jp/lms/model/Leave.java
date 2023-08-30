package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Data
@Entity(name = "Leave")
@Table(name = "leave")
public class Leave {
    @Id
    @GeneratedValue
    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer numOfDaysRequested;
    private String handoverTo;
    private String reason;
    @OneToOne
    private LeaveType leaveType;
    @OneToOne
    private Approvals approvals;
    @OneToOne
    private User user;
}
