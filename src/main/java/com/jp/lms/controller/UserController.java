package com.jp.lms.controller;

import com.jp.lms.model.User;
import com.jp.lms.repository.UserRepository;
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
@RequestMapping("/api/v1/users/")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("getAll")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
