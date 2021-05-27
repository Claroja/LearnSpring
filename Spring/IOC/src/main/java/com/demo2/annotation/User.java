package com.demo2.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.demo2"})  //扫描注解的包
public class User {
    @Value(value="wang")
    String name;

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(User.class);
        User user = context.getBean("user", User.class);
        System.out.println(user.name);
    }
}
