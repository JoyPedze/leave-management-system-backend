package com.jp.lms.service.impl;

import com.jp.lms.dto.payload.LeaveRequest;
import com.jp.lms.dto.response.LeaveResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.dto.response.department.DepartmentResponse;
import com.jp.lms.dto.response.leave.LeaveDepartmentResponse;
import com.jp.lms.model.*;
import com.jp.lms.model.enums.LeaveStatus;
import com.jp.lms.repository.LeaveRepository;
import com.jp.lms.repository.LeaveTypeRepository;
import com.jp.lms.repository.LevelRepository;
import com.jp.lms.repository.UserRepository;
import com.jp.lms.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;


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
    private final LevelRepository levelRepository;
    @Override
    public RequestSuccessful applyLeave(LeaveRequest leaveRequest) {
        LeaveType leaveType = leaveTypeRepository.findLeaveTypeByNameEqualsIgnoreCase(leaveRequest.getLeaveType());
        User user = userRepository.findById(leaveRequest.getUserId()).get();
        user.getWorkflow().getLevel().forEach(level -> level.setLeaveStatus(LeaveStatus.PENDING));

        Long numOfDaysRequested = DAYS.between(leaveRequest.getStartDate(),leaveRequest.getEndDate());

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

    @Override
    public List<LeaveResponse> getLeaves() {
        return leaveRepository
                .findAll()
                .stream()
                .map(leave -> new LeaveResponse(
                        leave.getStartDate(),
                        leave.getEndDate(),
                        leave.getNumOfDaysRequested(),
                        leave.getHandoverTo(),
                        leave.getReason(),
                        leave.getLeaveType().getName(),
                        leave.getUser().getFirstName(),
                        leave.getUser().getLastName(),
                        leave.getUser().getGender(),
                        leave.getUser().getDepartment().stream().map(department -> new LeaveDepartmentResponse(
                                department.getName()
                        )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponse> getDepartmentPendingLeaves(Long userId) {
        User user = userRepository.findById(userId).get();
        String levelName = user.getLevel().getName();
        List<Level> pendingLevels = levelRepository.findAllByNameAndLeaveStatus(levelName,LeaveStatus.PENDING);
        return null;
    }
}
