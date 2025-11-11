package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Leave;
import com.example.Employee.Management.System.Enums.StatusTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LeaveRepository extends JpaRepository<Leave,Long> {

    List<Leave> findByEmployeeId(Long id);

    // Find leaves by statusTypes
    List<Leave> findByStatus(StatusTypes status);

    @Query("SELECT l FROM Leave l WHERE l.status = 'APPROVED' AND l.start_date BETWEEN :start AND :end")
    List<Leave> findApprovedLeavesBetweenDates(@Param("start") java.time.LocalDate start,
                                               @Param("end") java.time.LocalDate end);

}
