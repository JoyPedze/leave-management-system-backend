package com.jp.lms.controller;

import com.jp.lms.model.Workflow;
import com.jp.lms.repository.WorkflowRepository;
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
@RequestMapping("/api/v1/workflows/")
public class WorkflowController {
    private final WorkflowRepository workflowRepository;

    @GetMapping("getAll")
    public List<Workflow> getWorkflows(){
        return workflowRepository.findAll();
    }
}
