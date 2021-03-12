package com.claroja;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.claroja.dao") //开启注解
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}