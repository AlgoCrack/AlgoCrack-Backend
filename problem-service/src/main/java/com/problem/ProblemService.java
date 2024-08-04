package com.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProblemService {

        private static final int CAPACITY = 2048;
        public static void main(String[] args) {
                SpringApplication application = new SpringApplication(ProblemService.class);
                application.setApplicationStartup(new BufferingApplicationStartup(CAPACITY));
                application.run(args);
                System.out.println("٩(๑❛ᴗ❛๑)۶  Problem Service 啟動!!  ٩(๑❛ᴗ❛๑)۶");
        }

}
