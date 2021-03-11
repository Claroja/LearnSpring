package demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页面
        http
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")//和login.html form表单的action保持一致;
            .successForwardUrl("/success")//登录成功后的跳转页面,Post请求
            .failureForwardUrl("/failure");//登录成功后的跳转页面,Post请求

        //授权
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()//放行/login.html，不需要认证
                 .antMatchers("/main").hasAuthority("admin")//基于权限
                .anyRequest().authenticated();//所有请求都必须认证才能访问，必须登录


        //退出
        http.logout()
                .logoutUrl("/logout");

        //关闭跨域防护
        http.csrf().disable();//关闭后才可以转发请求

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery("select username,authority from user where username=?");
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
