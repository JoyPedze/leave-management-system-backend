package com.jp.lms.service.impl;

import com.jp.lms.dto.payload.WorkflowRequest;
import com.jp.lms.dto.response.*;
import com.jp.lms.dto.response.workflow.WorkflowDepartmentResponse;
import com.jp.lms.dto.response.workflow.WorkflowLevelResponse;
import com.jp.lms.dto.response.workflow.WorkflowResponse;
import com.jp.lms.model.Level;
import com.jp.lms.model.Workflow;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.repository.WorkflowRepository;
import com.jp.lms.service.WorkflowService;
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
public class WorkflowServiceImpl implements WorkflowService {
    private final WorkflowRepository workflowRepository;
    private final LevelRepository levelRepository;
    @Override
    public List<WorkflowResponse> getWorkflows() {
        return workflowRepository
                .findAll()
                .stream()
                .map(workflow -> new WorkflowResponse(
                        workflow.getId(),
                        workflow.getName(),
                        workflow.getLevel()
                                .stream()
                                .map(level -> new WorkflowLevelResponse(
                                        level.getId(),
                                        level.getName(),
                                        level.getDepartment()
                                                .stream()
                                                .map(department -> new WorkflowDepartmentResponse(
                                                        department.getId(),
                                                        department.getName(),
                                                        department.getShortName(),
                                                        department.getEmail()
                                                ))
                                                .collect(Collectors.toList()),
                                        level.getWeight()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public RequestSuccessful saveWorkflow(WorkflowRequest workflowRequest) {
        List<Level> levels = levelRepository.findAllByNameIgnoreCaseIn(workflowRequest.getLevelNames());
        Workflow workflow = new Workflow();
        workflow.setName(workflowRequest.getName());
        workflow.setLevel(levels);
        workflowRepository.save(workflow);
        return new RequestSuccessful(HttpStatus.CREATED,"Workflow created successfully", LocalDateTime.now());
    }
}
