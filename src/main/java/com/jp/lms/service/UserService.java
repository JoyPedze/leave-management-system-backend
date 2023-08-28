package com.jp.lms.service;

import com.jp.lms.dto.response.UserResponse;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */
public interface UserService {
    List<UserResponse> getUsers();
}
