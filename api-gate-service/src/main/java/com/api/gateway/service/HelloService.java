package com.api.gateway.service;

import com.api.gateway.vo.HelloRequestVO;

public interface HelloService {

    String echo(String input);

    String hello(HelloRequestVO helloRequestVO);
}

