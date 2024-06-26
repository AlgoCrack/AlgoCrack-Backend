package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class AccountService {

        private static final int CAPACITY = 2048;
        public static void main(String[] args) {
                SpringApplication application = new SpringApplication(AccountService.class);
                application.setApplicationStartup(new BufferingApplicationStartup(CAPACITY));
                application.run(args);
                System.out.println("٩(๑❛ᴗ❛๑)۶  Account Service 啟動!!  ٩(๑❛ᴗ❛๑)۶");
        }

}
