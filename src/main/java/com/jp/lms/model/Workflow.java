package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Workflow")
@Table(name = "workflow")
public class Workflow {
    @Id
    @SequenceGenerator(name = "workflow_sequence",sequenceName = "workflow_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workflow_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "level_workflow",
            joinColumns = @JoinColumn(name = "level_id"),
            inverseJoinColumns = @JoinColumn(name = "workflow_id")
    )
    private List<Level> level;
    @OneToMany(mappedBy = "workflow")
    private List<User> users;

    public Workflow(String name, List<Level> level) {
        this.name = name;
        this.level = level;
    }
}
