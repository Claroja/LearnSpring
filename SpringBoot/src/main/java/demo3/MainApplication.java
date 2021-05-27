package demo3;

import demo3.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        boolean user = run.containsBean("user");
        System.out.println("容器中user组件："+user);

        boolean user2 = run.containsBean("user2");
        System.out.println("容器中user2组件："+user2);
    }
}