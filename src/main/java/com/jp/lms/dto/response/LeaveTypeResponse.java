package com.jp.lms.dto.response;

import lombok.Data;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

public record LeaveTypeResponse(
        Long id,
        String name,
        Long numOfDays,
        Double accumulation
) {
}
