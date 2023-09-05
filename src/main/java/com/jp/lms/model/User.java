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
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "first_name",nullable = false,columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name",nullable = false,columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "staff_position",nullable = false,columnDefinition = "TEXT")
    private String staffPosition;
    @Enumerated(value = EnumType.ORDINAL)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "level",referencedColumnName = "id",foreignKey = @ForeignKey(name = "_user_id_level_id_fk"))
    private Level level;
    @ManyToMany(mappedBy = "user")
    private List<Department> department;
    @ManyToOne
    @JoinColumn(name = "workflow_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "_user_id_workflow_id_fk"))
    private Workflow workflow;
    @OneToMany(mappedBy = "user")
    private List<Leave> leaves;

    public User(String firstName, String lastName, String email, String staffPosition, Gender gender, Level level, List<Department> department, Workflow workflow) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.staffPosition = staffPosition;
        this.gender = gender;
        this.level = level;
        this.department = department;
        this.workflow = workflow;
    }
}
