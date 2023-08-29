package com.jp.lms.repository;

import com.jp.lms.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */
@Repository
public interface LevelRepository extends JpaRepository<Level , Long> {
    List<Level> findAllByNameIgnoreCaseIn(List<String> names);
}
