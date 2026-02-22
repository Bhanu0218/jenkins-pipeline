package com.telusko.jenkins_pipeline.controller;

import com.telusko.jenkins_pipeline.model.Employee;
import com.telusko.jenkins_pipeline.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/emp")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/emp")
    public List<Employee>  findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/emp/{id}")
    public Employee findById(@PathVariable("id") Long empId) {
        return employeeService.findById(empId);
    }
}
