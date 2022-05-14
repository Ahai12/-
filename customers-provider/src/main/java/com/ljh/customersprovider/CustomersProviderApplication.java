package com.ljh.customersprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ljh.customersprovider.dao")
public class CustomersProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersProviderApplication.class, args);
    }

}
