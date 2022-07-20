package com.qcby.service.serviceImpl;

import com.qcby.dao.AccountDao;
import com.qcby.entity.Account;
import com.qcby.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAccount() {
        return this.accountDao.findAccount();
    }
}
