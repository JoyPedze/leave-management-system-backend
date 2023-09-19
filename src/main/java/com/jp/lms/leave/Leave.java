package com.jp.lms.leave;

import com.jp.lms.leave_type.LeaveType;
import com.jp.lms.user.User;
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
    @SequenceGenerator(name = "leave_sequence",sequenceName = "leave_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "startDate",nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate startDate;
    @Column(name = "endDate",nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate endDate;
    @Column(name = "numOfDaysRequested",nullable = false)
    private Long numOfDaysRequested;
    @Column(name = "handoverTo",nullable = false,columnDefinition = "TEXT")
    private String handoverTo;
    @Column(name = "reason",nullable = false,columnDefinition = "TEXT")
    private String reason;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // default
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "leave_type_id_leave_id_fk"))
    private LeaveType leaveType;
    @ManyToOne
    @JoinColumn(name = "user",referencedColumnName = "id",foreignKey = @ForeignKey(name = "leave_id_user_id_fk"))
    private User user;
}
