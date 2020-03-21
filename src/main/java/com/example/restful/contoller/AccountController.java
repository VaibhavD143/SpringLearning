package com.example.restful.contoller;

import com.example.restful.VO.Account;
import com.example.restful.VO.AccountAddRequest;
import com.example.restful.VO.Employee;
import com.example.restful.repository.AccountRepository;
import com.example.restful.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("account/")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/insert")
    public Account createEmployee(@Valid @RequestBody AccountAddRequest accountAddRequest)
    {
//        return accountRepository.save(account);
        Account account = accountAddRequest.getAccount();
        Employee employee = employeeRepository.getOne(accountAddRequest.getEmp_id());
        account.setEmployee(employee);
        return accountRepository.save(account);
    }

    @GetMapping("/getOne")
    public Account getAccount()
    {
        System.out.println(accountRepository.getOne(1));
        return accountRepository.getOne(1);
    }

}
