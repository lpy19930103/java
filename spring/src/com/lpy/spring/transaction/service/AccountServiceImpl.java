package com.lpy.spring.transaction.service;

import com.lpy.spring.transaction.dao.AccountDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String from, String to, double money) {
        accountDao.outMoney(from, money);
        accountDao.inMoney(to, money);

    }
}
