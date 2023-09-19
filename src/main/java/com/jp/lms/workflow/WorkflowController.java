package com.jp.lms.workflow;

import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.dto.response.workflow.WorkflowResponse;
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
@RequestMapping("/api/v1/workflows/")
public class WorkflowController {
    private final WorkflowService workflowService;

    @GetMapping("getAll")
    public ResponseEntity<List<WorkflowResponse>> getWorkflows(){
        return new ResponseEntity<>(workflowService.getWorkflows(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<RequestSuccessful> saveWorkflow(@RequestBody WorkflowRequest workflowRequest){
        return new ResponseEntity<>(workflowService.saveWorkflow(workflowRequest),HttpStatus.CREATED);
    }
}
