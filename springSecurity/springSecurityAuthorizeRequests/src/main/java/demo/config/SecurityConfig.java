package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页面
        http
            .formLogin()
//            .usernameParameter("username123")//自定义入参,需要和前端保持一致,默认是username
//            .passwordParameter("password123")//自定义入参,需要和前端保持一致,默认是password
            .loginPage("/login.html")
            .loginProcessingUrl("/login")//和login.html form表单的action保持一致;
            .successForwardUrl("/success")//登录成功后的跳转页面,Post请求
            .failureForwardUrl("/failure");//登录成功后的跳转页面,Post请求
        //授权
        http.authorizeRequests()

                .antMatchers("/login.html").permitAll()//放行/login.html，不需要认证
                // .antMatchers("/css/**","/js/**","/images/**").permitAll()//放行静态资源
                // .antMatchers("/**/*.png").permitAll()//放行后缀.png

                // .regexMatchers(".+[.]png").permitAll()//放行后缀.png,正则表达式
                // .regexMatchers(HttpMethod.POST,"/demo").permitAll()//指定请求方法

                 .antMatchers("/main").hasAuthority("admin")//基于权限
                // .antMatchers("/main1.html").hasAnyAuthority("admin","admiN")

                // .antMatchers("/main1.html").hasRole("abC")//基于角色
                // .antMatchers("/main1.html").hasAnyRole("abC","abc")

                // .antMatchers("/main1.html").hasIpAddress("127.0.0.1")//基于IP地址

                .anyRequest().authenticated();//所有请求都必须认证才能访问，必须登录

        //关闭跨域防护
        http.csrf().disable();//关闭后才可以转发请求

    }


    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
