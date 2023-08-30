package com.jp.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "LeaveType")
@Table(name = "leave_type")
public class LeaveType {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long numOfDays;

    public LeaveType(String name, Long numOfDays) {
        this.name = name;
        this.numOfDays = numOfDays;
    }
}
