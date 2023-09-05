package com.jp.lms.service.impl;

import com.jp.lms.dto.payload.LeaveTypeRequest;
import com.jp.lms.dto.response.LeaveTypeResponse;
import com.jp.lms.dto.response.RequestSuccessful;
import com.jp.lms.model.LeaveType;
import com.jp.lms.repository.LeaveTypeRepository;
import com.jp.lms.service.LeaveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Joy Pedze
 * @Email : joyp.pedze@gmail.com
 * @Date : 30 August 2023
 * @Project : lms
 */

@Service
@RequiredArgsConstructor
public class LeaveTypeServiceImpl implements LeaveTypeService {
    private final LeaveTypeRepository leaveTypeRepository;
    @Override
    public List<LeaveTypeResponse> getLeaveTypes() {
        return leaveTypeRepository
                .findAll()
                .stream()
                .map(leaveType -> new LeaveTypeResponse(
                        leaveType.getId(),
                        leaveType.getName(),
                        leaveType.getNumOfDays()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public RequestSuccessful saveLeaveType(LeaveTypeRequest leaveTypeRequest) {
        LeaveType leaveType = new LeaveType();
        leaveType.setName(leaveTypeRequest.getName());
        leaveType.setNumOfDays(leaveTypeRequest.getNumOfDays());
        leaveType.setAccumulation(leaveTypeRequest.getAccumulation());
        leaveTypeRepository.save(leaveType);
        return new RequestSuccessful(HttpStatus.CREATED,"Leave Type created successfully", LocalDateTime.now());
    }
}
