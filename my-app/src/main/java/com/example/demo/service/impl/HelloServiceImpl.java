package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.requestVO.HelloRequestVO;
import com.example.demo.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    @Value("${hello.chinese}")
    private String chineseGreeting;

    @Value("${hello.chinese}")
    private String englishGreeting;

    public String echo(String input) {
        return input;
    }

    public String hello(HelloRequestVO helloRequestVO) {
        String greeting = "";
        String language = helloRequestVO.getLanguage();
        Integer repeatTime = helloRequestVO.getRepeatTimes();

        while (repeatTime > 0) {
            repeatTime--;
            if ("chinese".equalsIgnoreCase(language)) {
                greeting += chineseGreeting + "\n";
            } else if ("english".equalsIgnoreCase(language)) {
                greeting += englishGreeting + "\n";
            }
        }

        return greeting;
    }
}