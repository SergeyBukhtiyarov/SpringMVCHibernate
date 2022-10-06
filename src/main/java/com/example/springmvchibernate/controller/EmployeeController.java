package com.example.springmvchibernate.controller;

import com.example.springmvchibernate.entity.Employee;
import com.example.springmvchibernate.repository.EmployeeRepository;
import com.example.springmvchibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/")
    public String startPage() {
        return "startPage";
    }

    @RequestMapping("/showAllEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("allEmps", employeeList);
        return "showAllEmployees";
    }

    @RequestMapping("/newEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "newEmployee";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("Newemp") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/showAllEmployees";
    }
    @RequestMapping("updateEmployee/{id}")
    public  String updateEmployee(@ModelAttribute("id") int id, Model model){
        Employee employee= employeeService.getEmployee(id);
        model.addAttribute("emp", employee);
        return "newEmployee";

    }
@RequestMapping("deleteEmployee/{id}")
    public String deleteEmploye(@ModelAttribute("id") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/showAllEmployees";
    }


}
