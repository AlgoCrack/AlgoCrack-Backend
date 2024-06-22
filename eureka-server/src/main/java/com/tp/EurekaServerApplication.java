package com.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

   public static void main(String[] args) {
      SpringApplication.run(EurekaServerApplication.class, args);
      System.out.println("٩(๑❛ᴗ❛๑)۶ EurekaServer 啟動!!  ٩(๑❛ᴗ❛๑)۶");
   }
}