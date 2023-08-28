package com.jp.lms.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 28 August 2023
 * @Project : lms
 */
public record RequestSuccessful(HttpStatus httpStatus, String message, LocalDateTime timestamp) {
}
