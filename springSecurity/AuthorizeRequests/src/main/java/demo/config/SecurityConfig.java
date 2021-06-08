package demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();//开启注册页面
        //授权
        http.authorizeRequests()
//                 .antMatchers("/login").permitAll()//放行`/login`, 默认的login页面, 不需要放行
//                 .antMatchers("/css/**","/js/**","/images/**").permitAll()//放行静态资源
//                 .antMatchers("/**/*.png").permitAll()//放行后缀.png
//                 .antMatchers("/xxxx/demo").permitAll()
//                 .antMatchers("/success").hasAuthority("admin")//权限控制,严格区分大小写
//                 .antMatchers("/success").hasAnyAuthority("admin","admiN")
                 .antMatchers("/success").hasRole("admin") //yml 配置文件中只能使用role
//                 .antMatchers("/success").hasAnyRole("abC","abc")
//                 .antMatchers("/success").hasIpAddress("127.0.0.1")//基于IP地址
                .anyRequest().authenticated();//所有请求都必须认证才能访问，必须登录
    }
}
