package com.demo1.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration  //作为配置类，替代xml配置文件
//@Component // 不需要, 因为@Configuration已经包含
@ComponentScan(basePackages = {"com"})  //扫描注解的包
public class User {
    public void say() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(com.demo1.xml.User.class);
        com.demo1.xml.User user = context.getBean("user", com.demo1.xml.User.class);//2 获取配置创建的对象
        System.out.println(user);
        user.say();
    }
}
