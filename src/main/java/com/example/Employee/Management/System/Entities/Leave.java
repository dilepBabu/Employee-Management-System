package com.example.Employee.Management.System.Entities;


import com.example.Employee.Management.System.Enums.LeaveTypes;
import com.example.Employee.Management.System.Enums.StatusTypes;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Employee employee;


    private LocalDate start_date;

    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private LeaveTypes leaveTypes;


    @Enumerated(EnumType.STRING)
    private StatusTypes statusTypes;


}
