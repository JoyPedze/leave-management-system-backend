package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    private List<Department> department;
    private Long weight;

    public Level(String name, List<Department> department, Long weight) {
        this.name = name;
        this.department = department;
        this.weight = weight;
    }
}