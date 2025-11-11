package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("SELECT d FROM Department d WHERE d.departmentName = :name")
    Department findByName(@Param("name") String name);

    @Query("""
            SELECT d from Department d where d.deptid =:deptid
            """)
    Department findDepartmentById(@Param("deptid") Long deptid);
}
