package com.auth.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth.vo.HelloRequestVO;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private HelloService helloService;


    @Test
	void testHello() {
        final Integer repeatTimes = 3;
        HelloRequestVO helloRequestVO = new HelloRequestVO();
        helloRequestVO.setLanguage("chinese");
        helloRequestVO.setRepeatTimes(repeatTimes);

        String result = helloService.hello(helloRequestVO);
        String expect = """
            來自 Spring Boot 的問候！
            來自 Spring Boot 的問候！
            來自 Spring Boot 的問候！
            """;

        assert result.equals(expect);
	}
}
