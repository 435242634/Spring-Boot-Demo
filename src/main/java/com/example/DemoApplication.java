package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 为了方便，没有新建控制器类，而是直接在入口类中编写代码
@SpringBootApplication  // Spring Boot 项目的核心注解，主要目的是开启自动配置
public class DemoApplication {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
