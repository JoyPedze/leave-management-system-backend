package com.jp.lms.repository;

import com.jp.lms.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
