package demo6.config;

import demo6.bean.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类, 相当于Spring的xml配置文件
@EnableConfigurationProperties(Person.class)
//1、开启User配置绑定功能
//2、把这个user这个组件自动注册到容器中
public class MyConfig {
}
