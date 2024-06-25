package com.userservice.service;

import com.userservice.vo.HelloRequestVO;

public interface HelloService {

    String echo(String input);

    String hello(HelloRequestVO helloRequestVO);
}

