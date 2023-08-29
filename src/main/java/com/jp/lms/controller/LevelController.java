package com.jp.lms.controller;

import com.jp.lms.dto.payload.LevelRequest;
import com.jp.lms.dto.response.LevelResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.model.Level;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final LevelService levelService;

    @GetMapping("getAll")
    public ResponseEntity<List<LevelResponse>> getLevels(){
        return new ResponseEntity<>(levelService.getLevels(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<RequestSuccessful> saveLevel(@RequestBody LevelRequest levelRequest){
        return new ResponseEntity<>(levelService.saveLevel(levelRequest),HttpStatus.CREATED);

    }
}
