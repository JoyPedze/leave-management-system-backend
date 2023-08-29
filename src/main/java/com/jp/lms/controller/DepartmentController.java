package com.jp.lms.controller;

import com.jp.lms.dto.payload.DepartmentRequest;
import com.jp.lms.dto.response.DepartmentResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.model.Department;
import com.jp.lms.repository.DepartmentRepository;
import com.jp.lms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final DepartmentService departmentService;

    @GetMapping("getAll")
    public ResponseEntity<List<DepartmentResponse>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<RequestSuccessful> saveDepartment(@RequestBody DepartmentRequest departmentRequest){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentRequest),HttpStatus.CREATED);
    }
}
