package com.demo5.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.demo5"})  //扫描注解的包
public class User {
    @Autowired
    Pen pen;
    public void write(){
        pen.writeHan();
    }

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(User.class);
        User user = context.getBean("user", User.class);
        user.write();
    }
}
