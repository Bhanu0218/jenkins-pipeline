package com.telusko.jenkins_pipeline.repo;

import com.telusko.jenkins_pipeline.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
