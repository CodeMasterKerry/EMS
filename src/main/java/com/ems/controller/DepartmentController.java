package com.ems.controller;

import com.ems.model.Department;
import com.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public String viewDepartmentsPage(Model model) {
        model.addAttribute("listDepartments", departmentService.getAllDepartments());
        return "departments/list";
    }

    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "departments/new";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "departments/update";
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }
}
