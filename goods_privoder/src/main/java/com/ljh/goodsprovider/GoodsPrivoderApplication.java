package com.ljh.goodsprovider;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient //能被注册中心发现，能扫描到服务
@MapperScan(basePackages = "com.ljh.goodsprovider.dao")
@EnableCircuitBreaker  //开启熔断机制
public class GoodsPrivoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsPrivoderApplication.class, args);
    }


    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
        registration.setName("HystrixMetricsStreamServlet");
        //设置启动优先级
        registration.setLoadOnStartup(1);
        //可视化界面
        registration.addUrlMappings("/hystrix.stream");
        return registration;

    }
}
