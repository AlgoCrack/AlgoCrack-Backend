package com.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.mapper.AccountMapper;
import com.auth.service.AccountService;
import com.auth.vo.AccountVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void addAccount(AccountVO accountVO) {
        accountMapper.addAccount(accountVO);
    }
}
