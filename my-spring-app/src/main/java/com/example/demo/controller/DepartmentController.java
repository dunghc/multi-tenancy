package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.configuration.GlobalPathVariable;
import com.example.demo.configuration.TenantContext;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
// @RequestMapping("/{tenantId}/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{tenantId}/api/departments")
    @GlobalPathVariable
    public String  getAllDepartments() {

        return "Handling MyData: Tenant ID: ok" ;
        // Set the tenant context dynamically based on the request header
       // TenantContext.setCurrentTenant(tenantId);
        // return departmentService.findAll();
    }

    @PostMapping("/{tenantId}/api/departments")
    public Department createDepartment(@RequestBody Department department) {
        // Set the tenant context dynamically based on the request header
        //TenantContext.setCurrentTenant(tenantId);
        return departmentService.save(department);
    }
}

