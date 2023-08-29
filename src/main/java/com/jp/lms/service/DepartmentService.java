package com.jp.lms.service;

import com.jp.lms.dto.payload.DepartmentRequest;
import com.jp.lms.dto.response.DepartmentResponse;
import com.jp.lms.dto.response.RequestSuccessful;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public interface DepartmentService {
    List<DepartmentResponse> getDepartments();

    RequestSuccessful saveDepartment(DepartmentRequest departmentRequest);
}
