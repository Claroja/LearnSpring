package com.demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    public void say() {
        System.out.println("hello");
    }
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo9.xml");//1 加载spring配置文件
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1);
        System.out.println(user2);
    }
}
