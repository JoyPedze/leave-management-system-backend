package com.jp.lms.service;

import com.jp.lms.dto.payload.LevelRequest;
import com.jp.lms.dto.response.LevelResponse;
import com.jp.lms.dto.response.RequestSuccessful;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 29 August 2023
 * @Project : lms
 */
public interface LevelService {
    List<LevelResponse> getLevels();

    RequestSuccessful saveLevel(LevelRequest levelRequest);
}
