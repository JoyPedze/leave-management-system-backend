package com.jp.lms.department;

import com.jp.lms.dto.response.RequestSuccessful;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getDepartments() {
        return departmentRepository
                .findAll()
                .stream()
                .map(department -> new DepartmentResponse(
                        department.getId(),
                        department.getName(),
                        department.getShortName(),
                        department.getEmail()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public RequestSuccessful saveDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());
        department.setShortName(departmentRequest.getShortName());
        department.setEmail(departmentRequest.getEmail());
        departmentRepository.save(department);
        return new RequestSuccessful(HttpStatus.CREATED,"Department created successfully", LocalDateTime.now());
    }
}
