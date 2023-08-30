package com.jp.lms.repository;

import com.jp.lms.model.Leave;
import com.jp.lms.model.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */
@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    @Query("SELECT l FROM LeaveType l WHERE UPPER(l.name) = UPPER(?1)")
    LeaveType findLeaveTypeByNameEqualsIgnoreCase(String name);
}
