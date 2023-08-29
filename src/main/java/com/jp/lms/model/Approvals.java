package com.jp.lms.model;

import com.jp.lms.model.enums.LeaveStatus;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Approvals")
@Table(name = "approvals")
public class Approvals {
    @Id
    @GeneratedValue
    private Long id;
    private String levelName;
    private String levelWeight;
    @Enumerated(value = EnumType.ORDINAL)
    private LeaveStatus leaveStatus;
}
