package demo3.config;

import demo3.bean.User;
import demo3.bean.User2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //配置类, 相当于Spring的xml配置文件
@ConditionalOnBean(name="user2") //卸载配置类上则是对整个配置类中的@Bean都生效, bug 此时@Bean还都没注入??
public class MyConfig {
    @Bean("user2")
    // @ConditionalOnBean(name="user") //这里将永远不能扫描到`user`, 因为@Bean的加载顺序是先加载`user2`, 再加载`user1`
    public User2 user2(){
        User2 wei = new User2("wei", 18);
        return wei;
    }

//    @ConditionalOnBean(name="user2") //首先去容器中查看是否有user2组件, 如果有则注入.
    @Bean("user")
    public User user(){
        User wang = new User("wang", 18);
        return wang;
    }
}
