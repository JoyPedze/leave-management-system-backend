package com.jp.lms.user;

import com.jp.lms.department.Department;
import com.jp.lms.leave.Leave;
import com.jp.lms.workflow.Workflow;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String workflowName;
    @ManyToMany
    @JoinTable(
            name = "_user_department",
            joinColumns = @JoinColumn(name = "_user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id",referencedColumnName = "id")
    )
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Leave> leaves;

    private void addDepartment(Department department){
        if (!this.departments.contains(department)){
            this.departments.add(department);
            department.getUser().add(this);
        }
    }
    private void applyLeave(Leave leave){
        this.leaves.add(leave);
        leave.setUser(this);
    }

    public User(String firstName, String lastName, String email, String staffPosition, Gender gender, String workflowName, List<Department> departments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.staffPosition = staffPosition;
        this.gender = gender;
        this.workflowName = workflowName;
        this.departments = departments;
    }
}

