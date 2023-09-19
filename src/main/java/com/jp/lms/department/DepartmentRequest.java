package com.jp.lms.department;

import lombok.Data;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */

@Data
public class DepartmentRequest {
    private String name;
    private String shortName;
    private String email;
}
