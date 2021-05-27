package com.demo3;

        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {
    public User(String name) {
        this.name = name;
    }
    String name;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo3.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(user.name);
    }
}
