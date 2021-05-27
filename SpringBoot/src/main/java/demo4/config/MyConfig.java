package demo4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration //配置类, 相当于Spring的xml配置文件
@ImportResource("classpath:beans.xml")
public class MyConfig {
}
