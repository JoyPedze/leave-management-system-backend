package com.jp.lms.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return  new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
