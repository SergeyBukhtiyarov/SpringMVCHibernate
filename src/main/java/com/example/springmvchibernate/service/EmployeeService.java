package com.example.springmvchibernate.service;

import com.example.springmvchibernate.entity.Employee;
import com.example.springmvchibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;

    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow();

    }


    public void deleteEmployee(int id) {
         employeeRepository.deleteById(id);
    }
}
