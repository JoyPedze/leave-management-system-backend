package com.jp.lms.controller;

import com.jp.lms.model.Department;
import com.jp.lms.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departments/")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @GetMapping("getAll")
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }
}
