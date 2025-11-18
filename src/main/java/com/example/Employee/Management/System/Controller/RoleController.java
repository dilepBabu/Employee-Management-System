package com.example.Employee.Management.System.Controller;


import com.example.Employee.Management.System.Entities.Role;
import com.example.Employee.Management.System.Repository.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RoleController {


    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @PostMapping("/addrole")
    public Role addrole(@RequestBody Role role)
    {
        return roleRepository.save(role);
    }
}
