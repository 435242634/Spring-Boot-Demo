package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

        // 关闭 banner
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Value("${book.name}")
    private String bookName;

    @Value("${book.price}")
    private double bookPrice;

    @Autowired
    private BookProperties bookProperties;

    @RequestMapping("/")
    public String index() {
        return bookProperties.getName() + bookProperties.getPrice();
    }
}
