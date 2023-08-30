package com.jp.lms.service.impl;

import com.jp.lms.dto.payload.LeaveRequest;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.model.Leave;
import com.jp.lms.model.LeaveType;
import com.jp.lms.model.Level;
import com.jp.lms.model.User;
import com.jp.lms.model.enums.LeaveStatus;
import com.jp.lms.repository.LeaveRepository;
import com.jp.lms.repository.LeaveTypeRepository;
import com.jp.lms.repository.UserRepository;
import com.jp.lms.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {
    private final LeaveTypeRepository leaveTypeRepository;
    private final UserRepository userRepository;
    private final LeaveRepository leaveRepository;
    @Override
    public RequestSuccessful applyLeave(LeaveRequest leaveRequest) {
        LeaveType leaveType = leaveTypeRepository.findLeaveTypeByNameEqualsIgnoreCase(leaveRequest.getLeaveType());
        User user = userRepository.findById(leaveRequest.getUserId()).get();
        user.getWorkflow().getLevel().forEach(level -> level.setLeaveStatus(LeaveStatus.PENDING));


        Period period = Period.between(leaveRequest.getEndDate(),leaveRequest.getStartDate());
        Integer numOfDaysRequested = period.getDays();

        Leave leave = new Leave();
        leave.setStartDate(leaveRequest.getStartDate());
        leave.setEndDate(leaveRequest.getEndDate());
        leave.setNumOfDaysRequested(numOfDaysRequested);
        leave.setHandoverTo(leaveRequest.getHandoverTo());
        leave.setReason(leaveRequest.getReason());
        leave.setLeaveType(leaveType);
        leave.setUser(user);

       leaveRepository.save(leave);

        return new RequestSuccessful(HttpStatus.CREATED,"Leave Application Successful", LocalDateTime.now());
    }
}
