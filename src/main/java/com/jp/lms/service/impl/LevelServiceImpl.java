package com.jp.lms.service.impl;

import com.jp.lms.dto.payload.LevelRequest;
import com.jp.lms.dto.response.LevelResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.model.Department;
import com.jp.lms.model.Level;
import com.jp.lms.repository.DepartmentRepository;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public List<LevelResponse> getLevels() {
        return levelRepository
                .findAll()
                .stream()
                .map(level -> new LevelResponse(
                        level.getId(),
                        level.getName(),
                        level.getDepartment(),
                        level.getWeight()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public RequestSuccessful saveLevel(LevelRequest levelRequest) {
        List<Department> departments = departmentRepository.findAllByNameIgnoreCaseIn(levelRequest.getDepartmentNames());

        Level level = new Level();
        level.setName(levelRequest.getName());
        level.setDepartment(departments);
        level.setWeight(levelRequest.getWeight());
        levelRepository.save(level);

        return new RequestSuccessful(HttpStatus.CREATED,"Level created successfully", LocalDateTime.now());
    }
}
