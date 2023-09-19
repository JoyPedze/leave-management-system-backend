package com.jp.lms.workflow;

import com.jp.lms.workflow.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
}
