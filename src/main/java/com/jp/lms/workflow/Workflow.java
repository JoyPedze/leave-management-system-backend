package com.jp.lms.workflow;

import com.jp.lms.user.User;
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
@Entity(name = "Workflow")
@Table(name = "workflow")
public class Workflow {
    @Id
    @SequenceGenerator(name = "workflow_sequence",sequenceName = "workflow_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workflow_sequence")
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;
    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @OneToMany
    @JoinColumn(name = "_user_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "workflow_id_user_id_fk"))
    private List<User> users = new ArrayList<>();

    private void addUser(User user){
        this.users.add(user);
    }

    public Workflow(String name) {
        this.name = name;
    }
}
