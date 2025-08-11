package com.wiremock.wiremock.service;

import com.wiremock.wiremock.model.Employee;
import com.wiremock.wiremock.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee saveEmployee (Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployee(Long id){

        return employeeRepository.findById(id);
    }
}
