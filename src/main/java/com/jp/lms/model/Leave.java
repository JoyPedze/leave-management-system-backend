package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Data
@Entity(name = "Leave")
@Table(name = "leaves")
public class Leave {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long numOfDaysRequested;
    private String handoverTo;
    private String reason;
    @OneToOne
    private LeaveType leaveType;
//    @OneToMany
//    private List<Level> levels;
    @OneToOne
    private User user;
}
