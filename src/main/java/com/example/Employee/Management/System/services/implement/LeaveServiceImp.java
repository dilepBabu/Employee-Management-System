package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Entities.Leave;
import com.example.Employee.Management.System.Enums.StatusTypes;
import com.example.Employee.Management.System.Repository.LeaveRepository;
import com.example.Employee.Management.System.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveServiceImp implements LeaveService {
    @Autowired
   private LeaveRepository leaveRepository;

    @Override
    public Leave applyLeave(Leave leave) {
        leave.setStatus(StatusTypes.PENDING);
        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave approveLeave(Long leaveId) {
        Leave leave=leaveRepository.findById(leaveId).orElseThrow(()->new RuntimeException("Leave not found"));
        leave.setStatus(StatusTypes.APPROVED);
        return leaveRepository.save(leave);
    }

    @Override
    public Leave rejectLeave(Long leaveId) {
        Leave leave=leaveRepository.findById(leaveId).orElseThrow(()->new RuntimeException("Leave not found"));
        leave.setStatus(StatusTypes.REJECTED);
        return leaveRepository.save(leave);

    }
}
