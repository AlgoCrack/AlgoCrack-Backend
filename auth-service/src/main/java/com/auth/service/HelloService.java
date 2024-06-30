package com.auth.service;

import com.auth.vo.HelloRequestVO;

public interface HelloService {

    String echo(String input);

    String hello(HelloRequestVO helloRequestVO);
}

