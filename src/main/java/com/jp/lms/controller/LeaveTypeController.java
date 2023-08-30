package com.jp.lms.controller;

import com.jp.lms.dto.payload.LeaveTypeRequest;
import com.jp.lms.dto.response.LeaveTypeResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leaveTypes/")
public class LeaveTypeController {
    private final LeaveTypeService leaveTypeService;

    @GetMapping("getAll")
    public ResponseEntity<List<LeaveTypeResponse>> getLeaveTypes(){
        return new ResponseEntity<>(leaveTypeService.getLeaveTypes(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<RequestSuccessful> saveLeaveType(@RequestBody LeaveTypeRequest leaveTypeRequest){
        return new ResponseEntity<>(leaveTypeService.saveLeaveType(leaveTypeRequest),HttpStatus.CREATED);
    }
}
