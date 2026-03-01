package com.ems.controller;

import com.ems.model.Employee;
import com.ems.service.DepartmentService;
import com.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(name="keyword", required=false) String keyword) {
        List<Employee> listEmployees = employeeService.searchEmployees(keyword);
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employees/new";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employees/update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
