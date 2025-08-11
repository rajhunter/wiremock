package com.wiremock.wiremock.repository;

import com.wiremock.wiremock.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Optionally define custom methods like:
    // List<Employee> findByDepartment(String department);
}
