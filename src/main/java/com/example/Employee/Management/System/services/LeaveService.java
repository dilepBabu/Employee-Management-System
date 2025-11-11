package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Leave;

import java.util.List;

public interface LeaveService {

    Leave applyLeave(Leave leave);
    List<Leave> getAllLeaves();
    Leave approveLeave(Long leaveId);
    Leave rejectLeave(Long leaveId);
}
