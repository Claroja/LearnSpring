package com.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    String name1;
    String name2;
    public void setName1(String name) {
        this.name1 = name;
    }
    public void setName2(String name) {
        this.name2 = name;
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo4.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(user.name1 + user.name2);
    }
}
