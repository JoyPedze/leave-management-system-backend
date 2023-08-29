package com.jp.lms.service;

import com.jp.lms.dto.payload.WorkflowRequest;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.dto.response.WorkflowResponse;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public interface WorkflowService {
    List<WorkflowResponse> getWorkflows();

    RequestSuccessful saveWorkflow(WorkflowRequest workflowRequest);
}
