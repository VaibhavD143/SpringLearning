package com.example.restful.contoller;

import com.example.restful.VO.Address;
import com.example.restful.VO.Employee;
import com.example.restful.repository.AddressRepository;
import com.example.restful.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("address/")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @GetMapping("/getOne")
    public Address getAddress(@RequestParam Integer id){
        return addressRepository.getOne(id);
    }

    @PostMapping("/insert")
    public Address createEmployee(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

}
