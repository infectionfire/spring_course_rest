package com.ivanovsergei.spring.rest.controller;

import com.ivanovsergei.spring.rest.entity.Employee;
import com.ivanovsergei.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//управляет рест запросами и ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

    List<Employee> allEmployees = employeeService.getAllEmployees();
    return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){//с помощью аннтоации передается число в метод и выводится результат
        Employee employee = employeeService.getEmployee(id);

        return employee;//json получается автоматически при помощи спринга и джексон датабайнд
    }



}
