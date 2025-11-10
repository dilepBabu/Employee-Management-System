package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {



    List<Attendance> findByEMployeeId(Long id);


    @Query("""
            SELECT a FROM Attendance a WHERE a.employee.employeename= :name AND a.date =:date
            """)
    Attendance findByNameAndDate(@Param("name")String name, @Param("date") LocalDate date);

    @Query("""
            SELECT a FROM Attendance a WHERE a.employee.id= :id AND a.date =:date
            """)
    Attendance findByIdAndDate(@Param("id")Long id, @Param("date") LocalDate date);


}
