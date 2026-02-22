package com.telusko.jenkins_pipeline.service;

import com.telusko.jenkins_pipeline.model.Employee;
import com.telusko.jenkins_pipeline.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findById(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
