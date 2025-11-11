package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Entities.Payroll;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import com.example.Employee.Management.System.Repository.PayrollRepository;
import com.example.Employee.Management.System.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class PayrollServiceImp implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Payroll generatePayroll(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        Payroll payroll=new Payroll();
        payroll.setEmployee(employee);
        payroll.setMonth(Month.NOVEMBER);
        payroll.setBonus(3000l);
        payroll.setDeductions(1000l);
        payroll.setBase_salary(25000l);
        payroll.setTotal_salary(payroll.getBase_salary()+payroll.getBonus()-payroll.getDeductions());
        return payrollRepository.save(payroll);


    }

    @Override
    public List<Payroll> getPayrollsByEmployee(Long id) {
        return payrollRepository.findByEmployeeId(id);
    }
}
