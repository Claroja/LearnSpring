package demo1.config;

import demo1.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //配置类, 相当于Spring的xml配置文件
public class MyConfig {
    @Bean //给容器中添加组件。以`方法名`作为组件的id, 返回类型就是组件类型.
    public User user(){
        User zhangsan = new User("wang", 18);
        return zhangsan;
    }
}
