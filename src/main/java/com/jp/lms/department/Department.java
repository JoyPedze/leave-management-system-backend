package com.jp.lms.department;

import com.jp.lms.user.User;
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
@Entity(name = "Department")
@Table(name = "department")
public class Department {
    @Id
    @SequenceGenerator(name = "department_sequence",sequenceName = "department_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;
    @Column(name = "short_name",nullable = false,columnDefinition = "TEXT")
    private String shortName;
    @Column(name = "email",nullable = false)
    private String email;
    @ManyToMany(mappedBy = "departments")
    private List<User> user;

    public Department(String name, String shortName, String email) {
        this.name = name;
        this.shortName = shortName;
        this.email = email;
    }
}
