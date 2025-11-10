package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LeaveRepository extends JpaRepository<Leave,Long> {

    List<Leave> findByEmployeeId(Long employeeId);

    // Find leaves by status
    List<Leave> findByStatus(String status);

    // JPQL: Get approved leaves between two dates
    @Query("SELECT l FROM Leave l WHERE l.statusTypes = 'APPROVED' AND l.start_date BETWEEN :start AND :end")
    List<Leave> findApprovedLeavesBetweenDates(@Param("start") java.time.LocalDate start,
                                               @Param("end") java.time.LocalDate end);

}
