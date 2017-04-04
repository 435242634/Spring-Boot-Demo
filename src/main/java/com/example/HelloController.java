package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by FlySheep on 17/4/4.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "hello world!";
    }
}
