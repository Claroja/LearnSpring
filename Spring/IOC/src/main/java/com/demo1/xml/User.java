package com.demo1.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    public void say() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("beanDemo1.xml");//1 加载spring配置文件
//        ApplicationContext是BeanFactory的子接口,所以可以替换, 本质就是BeanFactory
//        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo1.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(user);
        user.say();
    }
}
