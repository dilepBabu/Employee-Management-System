package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll,Long> {



    List<Payroll> findByEmployeeId(Long employeeId);


    @Query("SELECT p FROM Payroll p WHERE p.month = :month")
    List<Payroll> findByMonth(@Param("month") String month);
}
