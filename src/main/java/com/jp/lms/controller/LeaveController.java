package com.jp.lms.controller;


import com.jp.lms.dto.payload.LeaveRequest;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leaves/")
public class LeaveController {
    private final LeaveService leaveService;

    @PostMapping("apply")
    public ResponseEntity<RequestSuccessful> applyLeave(@RequestBody LeaveRequest leaveRequest){
        return new ResponseEntity<>(leaveService.applyLeave(leaveRequest), HttpStatus.CREATED);
    }

}
