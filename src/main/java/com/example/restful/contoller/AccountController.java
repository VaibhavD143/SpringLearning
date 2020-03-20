package com.example.restful.contoller;

import com.example.restful.VO.Account;
import com.example.restful.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("account/")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/getAll")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping("/insert")
    public String createEmployee(@Valid @RequestBody Account account,@RequestBody String str1)
    {
//        return accountRepository.save(account);
        return account.toString() +" "+ str1;
    }

}
