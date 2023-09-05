package com.jp.lms.model;

import jakarta.persistence.*;
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
    @SequenceGenerator(name = "leave_type_sequence",sequenceName = "leave_type_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_type_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;
    @Column(name = "num_of_days",nullable = false)
    private Long numOfDays;
    @Column(name = "accumulation",nullable = false)
    private Double accumulation;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // default
    @JoinColumn(name = "leave_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "leave_type_id_leave_id_fk"))
    private Leave leave;

    public LeaveType(String name, Long numOfDays, Double accumulation) {
        this.name = name;
        this.numOfDays = numOfDays;
        this.accumulation = accumulation;
    }
}
