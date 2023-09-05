package com.jp.lms.model;

import com.jp.lms.model.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Level")
@Table(name = "level")
public class Level {
    @Id
    @SequenceGenerator(name = "level_sequence",sequenceName = "level_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "level_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;
    @Column(name = "weight",nullable = false)
    private Long weight;
    @Enumerated(value = EnumType.ORDINAL)
    private LeaveStatus leaveStatus;
    @ManyToMany
    @JoinTable(
            name = "level_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "level_id")
    )
    private List<Department> department = new ArrayList<>();
    @ManyToMany(mappedBy = "level")
    private List<Workflow> workflows;
    @OneToMany(mappedBy = "level")
    private List<User> user;

    public Level(String name, Long weight, List<Department> department) {
        this.name = name;
        this.weight = weight;
        this.department = department;
    }
}
