package com.example.restful.contoller;

import com.example.restful.VO.Employee;
import com.example.restful.repository.AddressRepository;
import com.example.restful.repository.EmployeeRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        List<Employee> lst = employeeRepository.findAll();
        System.out.println("fired!");
        return lst;
    }

    @PostMapping("/insert")
    public Employee createEmployee(@Valid @RequestBody Employee employee)
    {
        employee.setAddress(addressRepository.getOne(1));
        return employeeRepository.save(employee);
    }

    @GetMapping("/getOne")
    public Employee getEmployee(@RequestParam Integer id) throws InterruptedException {
        Employee emp = employeeRepository.getOne(id);
        System.out.println(emp.getEmail());
        System.out.println("fired!");
        return employeeRepository.getOne(id);
    }
}
