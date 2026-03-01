package com.ems.service;

import com.ems.model.Department;
import com.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
