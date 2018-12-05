package com.lpy.spring.transaction.service;

public interface AccountService {
    void transfer(String from, String to, double money);
}
