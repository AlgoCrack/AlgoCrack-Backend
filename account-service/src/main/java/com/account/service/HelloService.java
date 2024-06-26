package com.account.service;

import com.account.vo.HelloRequestVO;

public interface HelloService {

    String echo(String input);

    String hello(HelloRequestVO helloRequestVO);
}

