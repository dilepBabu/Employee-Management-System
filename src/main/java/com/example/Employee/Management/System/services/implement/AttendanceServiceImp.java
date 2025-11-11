package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Attendance;
import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Repository.AttendanceRepository;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import com.example.Employee.Management.System.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public class AttendanceServiceImp implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Attendance> getEmployeeById(Long id) {
        return attendanceRepository.findByEmployeeId(id);
    }

    @Override
    public Attendance markAttendance(Long id) {


        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException(" Employee not found"));
        LocalDate date=LocalDate.now();
        Attendance existing=attendanceRepository.findByIdAndDate(id,date);
        if(existing!=null)
        {
            existing.setCheckOutTime(LocalDateTime.now());
            return attendanceRepository.save(existing);
        }

        Attendance attendance=new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(date);
        attendance.setCheckInTime(LocalDateTime.now());
        return attendanceRepository.save(attendance);

    }
}
