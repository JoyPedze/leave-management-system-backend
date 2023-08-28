package com.jp.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Entity
@Data
@Table(name = "_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    public User(String name, String email, Workflow workflow) {
        this.name = name;
        this.email = email;
        this.workflow = workflow;
    }
}
