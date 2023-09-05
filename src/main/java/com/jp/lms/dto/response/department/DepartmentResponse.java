package com.jp.lms.dto.response.department;

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
