package com.demo2.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    String name;
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo2.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(user.name);
    }
}
