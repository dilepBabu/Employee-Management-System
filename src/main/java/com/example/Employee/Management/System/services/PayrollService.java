package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Payroll;

import java.util.List;

public interface PayrollService {

    Payroll generatePayroll(Long id);
    List<Payroll> getPayrollsByEmployee(Long id);
}
