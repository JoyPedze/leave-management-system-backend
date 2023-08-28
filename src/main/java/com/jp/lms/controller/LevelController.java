package com.jp.lms.controller;

import com.jp.lms.model.Level;
import com.jp.lms.repository.LevelRepository;
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
@RequestMapping("/api/v1/levels/")
public class LevelController {
    private final LevelRepository levelRepository;

    @GetMapping("getAll")
    public List<Level> getLevels(){
        return levelRepository.findAll();
    }
}
