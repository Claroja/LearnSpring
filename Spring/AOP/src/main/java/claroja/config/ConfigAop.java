package claroja.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"claroja"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
