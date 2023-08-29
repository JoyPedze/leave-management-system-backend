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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Workflow")
@Table(name = "workflow")
public class Workflow {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany
    private List<Level> level;

    public Workflow(String name, List<Level> level) {
        this.name = name;
        this.level = level;
    }
}
