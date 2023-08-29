package com.jp.lms.dto.payload;

import com.jp.lms.model.Department;
import lombok.Data;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
@Data
public class LevelRequest {
    private String name;
    private List<String> departmentNames;
    private Long weight;
}
