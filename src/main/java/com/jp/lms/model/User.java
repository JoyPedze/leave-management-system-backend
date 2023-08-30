package com.jp.lms.model;

import com.jp.lms.model.enums.Gender;
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
@Entity(name = "User")
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String staffPosition;
    @OneToOne
    private Level level;
    @OneToMany
    private List<Department> department;
    @Enumerated(value = EnumType.ORDINAL)
    private Gender gender;
    @OneToOne
    private Workflow workflow;

    public User(String firstName, String lastName, String email, String staffPosition, Level level, List<Department> department, Gender gender, Workflow workflow) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.staffPosition = staffPosition;
        this.level = level;
        this.department = department;
        this.gender = gender;
        this.workflow = workflow;
    }
}
