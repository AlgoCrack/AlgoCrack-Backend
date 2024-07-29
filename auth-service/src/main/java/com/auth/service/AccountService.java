package com.auth.service;

import com.auth.vo.AccountVO;

import jakarta.servlet.http.HttpServletResponse;

public interface AccountService {

    void addAccount(AccountVO accountVO);

    String setJWT(AccountVO accountVO, HttpServletResponse response) throws Exception;
}

