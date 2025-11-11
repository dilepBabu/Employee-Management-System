package com.example.Employee.Management.System.Entities;


import com.example.Employee.Management.System.Enums.LeaveTypes;
import com.example.Employee.Management.System.Enums.StatusTypes;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    private LocalDate start_date;

    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private LeaveTypes leaveTypes;



    @Enumerated(EnumType.STRING)
    private StatusTypes status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LeaveTypes getLeaveTypes() {
        return leaveTypes;
    }

    public void setLeaveTypes(LeaveTypes leaveTypes) {
        this.leaveTypes = leaveTypes;
    }

    public StatusTypes getStatus() {
        return status;
    }

    public void setStatus(StatusTypes status) {
        this.status = status;
    }
}
