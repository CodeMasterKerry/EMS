package com.ems.service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchEmployees(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return employeeRepository.searchEmployees(keyword);
        }
        return employeeRepository.findAll();
    }
}
