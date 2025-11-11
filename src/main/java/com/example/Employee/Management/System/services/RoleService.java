package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Role;
import com.example.Employee.Management.System.Enums.RoleTypes;

import java.util.List;

public interface RoleService {

    List<Role> getallEmployeeByRole(RoleTypes role);

}
