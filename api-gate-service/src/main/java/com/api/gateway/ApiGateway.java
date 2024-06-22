package com.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class ApiGateway {

        private static final int CAPACITY = 2048;
        public static void main(String[] args) {
                SpringApplication application = new SpringApplication(ApiGateway.class);
                application.setApplicationStartup(new BufferingApplicationStartup(CAPACITY));
                application.run(args);
                System.out.println("٩(๑❛ᴗ❛๑)۶  ApiGatewayService 啟動!!  ٩(๑❛ᴗ❛๑)۶");
        }

}
