package com.jp.lms.workflow;

import lombok.Data;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */

@Data
public class WorkflowRequest {
    private String name;
    private List<String> levelNames;

}
