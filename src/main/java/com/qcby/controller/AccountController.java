package com.qcby.controller;

import com.qcby.entity.Account;
import com.qcby.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("findAccount")
    @ResponseBody
    public List<Account> findAccount(){
       List<Account> ans= this.accountService.findAccount();
       return ans;
    }
}
