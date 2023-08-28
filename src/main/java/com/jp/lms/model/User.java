package com.jp.lms.model;

import com.jp.lms.model.enums.Gender;
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
    private String firstName;
    private String lastName;
    private String email;
    private String staffPosition;
    @Enumerated(value = EnumType.ORDINAL)
    private Gender gender;
    @OneToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;

    public User(String firstName, String lastName, String email, String staffPosition, Gender gender, Workflow workflow) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.staffPosition = staffPosition;
        this.gender = gender;
        this.workflow = workflow;
    }
}
