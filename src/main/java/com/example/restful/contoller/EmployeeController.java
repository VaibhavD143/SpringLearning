package com.example.restful.contoller;

import com.example.restful.VO.Employee;
import com.example.restful.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/insert`")
    public Employee createEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

}
