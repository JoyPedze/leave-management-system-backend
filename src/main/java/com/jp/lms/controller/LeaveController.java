package com.jp.lms.controller;


import com.jp.lms.dto.payload.LeaveRequest;
import com.jp.lms.dto.response.LeaveResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leaves/")
public class LeaveController {
    private final LeaveService leaveService;

    @GetMapping("getAll")
    public ResponseEntity<List<LeaveResponse>> getLeaves(){
        return new ResponseEntity<>(leaveService.getLeaves(),HttpStatus.OK);
    }

    @PostMapping("apply")
    public ResponseEntity<RequestSuccessful> applyLeave(@RequestBody LeaveRequest leaveRequest){
        return new ResponseEntity<>(leaveService.applyLeave(leaveRequest), HttpStatus.CREATED);
    }

    @GetMapping("departmentPending/{id}")
    public ResponseEntity<List<LeaveResponse>> getDepartmentPendingLeaves(@PathVariable("id") Long userId){
        return new ResponseEntity<>(leaveService.getDepartmentPendingLeaves(userId),HttpStatus.OK);
    }

}
