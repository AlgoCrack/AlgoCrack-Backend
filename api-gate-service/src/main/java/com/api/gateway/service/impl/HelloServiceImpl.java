package com.api.gateway.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.gateway.service.HelloService;
import com.api.gateway.vo.HelloRequestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Value("${hello.chinese}")
    private String chineseGreeting;

    @Value("${hello.english}")
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
        log.info("use: " + language + " to greeting~");
        return greeting;
    }
}
