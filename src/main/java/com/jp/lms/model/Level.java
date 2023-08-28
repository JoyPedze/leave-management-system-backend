package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String department;
    private Long weight;

    public Level(String name, String department, Long weight) {
        this.name = name;
        this.department = department;
        this.weight = weight;
    }
}
