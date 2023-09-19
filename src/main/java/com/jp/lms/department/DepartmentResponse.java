package com.jp.lms.department;

import com.jp.lms.user.User;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public record DepartmentResponse(
        Long id,
        String name,
        String shortName,
        String email
) {
}
