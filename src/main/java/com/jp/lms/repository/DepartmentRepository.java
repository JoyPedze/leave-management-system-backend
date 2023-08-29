package com.jp.lms.repository;

import com.jp.lms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAllByNameIgnoreCaseIn(List<String> name);
}
