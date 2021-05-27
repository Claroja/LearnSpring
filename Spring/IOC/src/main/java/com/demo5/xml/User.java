package com.demo5.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void write(){
        pen.writeHan();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo5.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        user.write();
    }
}
