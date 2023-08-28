package com.jp.lms.controller;

import com.jp.lms.model.Level;
import com.jp.lms.model.User;
import com.jp.lms.model.Workflow;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.repository.UserRepository;
import com.jp.lms.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class LeaveController {

    private final LevelRepository levelRepository;
    private final WorkflowRepository workflowRepository;
    private final UserRepository userRepository;

    @GetMapping("levels")
    public List<Level> getLevels(){
        return levelRepository.findAll();
    }

    @GetMapping("workflows")
    public List<Workflow> getWorkflows(){
        return workflowRepository.findAll();
    }

    @GetMapping("users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }



}
