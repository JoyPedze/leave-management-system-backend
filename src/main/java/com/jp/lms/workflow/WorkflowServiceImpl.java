package com.jp.lms.workflow;

import com.jp.lms.dto.response.*;
import com.jp.lms.dto.response.workflow.WorkflowDepartmentResponse;
import com.jp.lms.dto.response.workflow.WorkflowLevelResponse;
import com.jp.lms.dto.response.workflow.WorkflowResponse;
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

    @Override
    public List<WorkflowResponse> getWorkflows() {
        return workflowRepository
                .findAll()
                .stream()
                .map(workflow -> new WorkflowResponse(
                        workflow.getId(),
                        workflow.getName(),
                        workflow.getUsers()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public RequestSuccessful saveWorkflow(WorkflowRequest workflowRequest) {
        Workflow workflow = new Workflow();
        workflow.setName(workflowRequest.getName());
        workflowRepository.save(workflow);
        return new RequestSuccessful(HttpStatus.CREATED,"Workflow created successfully", LocalDateTime.now());
    }
}
