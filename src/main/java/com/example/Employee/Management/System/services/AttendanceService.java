package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> getEmployeeById(Long id);

    Attendance markAttendance(Long id);


}
