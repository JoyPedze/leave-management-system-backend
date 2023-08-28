package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workflow {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Level> level;

    public Workflow(String name, List<Level> level) {
        this.name = name;
        this.level = level;
    }
}
