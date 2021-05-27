package com.demo10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {

    //无参数构造
    public User() {
        System.out.println("第一步 无参数构造创建bean实例");
    }

    private String name;
    public void setName(String name) {
        this.name = name;
        System.out.println("第二步 调用set方法设置属性值");
    }

    public void initMethod() {
        System.out.println("第三步 执行初始化方法");
    }//需在xml中指定
    public void destroyMethod() {
        System.out.println("第五步 执行销毁方法");
    }//需在xml中指定

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanDemo10.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(user);//第4步使用bean
        context.close();//销毁实例
    }
}
