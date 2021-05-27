package com.demo6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    //1 数组类型属性
    private String[] strs;
    //2 list集合类型属性
    private List<String> list;
    private List<Pen> listO;
    //3 map集合类型属性
    private Map<String,String> map;
    //4 set集合类型属性
    private Set<String> set;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setListO(List<Pen> listO) {
        this.listO = listO;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> sets) {
        this.set = set;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDemo6.xml");//1 加载spring配置文件
        User user = context.getBean("user", User.class);//2 获取配置创建的对象
        System.out.println(Arrays.toString(user.strs));
        System.out.println(user.list);
        System.out.println(user.listO);
        System.out.println(user.map);
        System.out.println(user.set);

    }
}
