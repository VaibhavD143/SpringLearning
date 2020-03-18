package com.example.restful.contoller;

import com.example.restful.Employee;
import com.example.restful.EmplyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {

    @Autowired
    EmplyeeRepository emplyeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return emplyeeRepository.findAll();
    }
}
