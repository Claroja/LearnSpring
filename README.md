# Spring

每个packge(demo)对应不同的xml文件(beanDemo*.xml)


### LearnSpring/SpringSecurity/FormLogin

### formLogin
主要用来配置登录页面.
- `usernameParameter`和`passwordParameter`用来配置登录表单提交的参数, 默认为`username`和`password`
- `loginPage` 自定义登录页面, 有实现的默认页面. `get`请求, 要在`controller`中自己配置
    自定义页面默认开启了csrf, 所以要添加`<input type="hidden" name="_csrf" th:value="${_csrf.token}" th:if="${_csrf}">`
    如果不想添加, 可以使用`http.csrf().disable()`来关闭, 不建议
- `loginProcessingUrl` 登录处理页面, `form`表单的`action`, `post`请求
- `successForwardUrl` 成功的转发, `controller`中自己配置
- `failureForwardUrl` 失败的转发, `controller`中自己配置

另外, 要使用`authorizeRequests`, 对`/login`来放行

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    //自定义登录页面
    http
        .formLogin()
//            .usernameParameter("username123")//自定义入参,需要和前端保持一致,默认是username
//            .passwordParameter("password123")//自定义入参,需要和前端保持一致,默认是password
        .loginPage("/login")
        .loginProcessingUrl("/login")//和login.html form表单的action保持一致;
        .successForwardUrl("/success")//登录成功后的跳转页面,Post请求
        .failureForwardUrl("/failure");//登录成功后的跳转页面,Post请求
    //授权
    http
        .authorizeRequests()
        .antMatchers("/login").permitAll()//放行自定义的登录页面
        .anyRequest().authenticated();//所有请求必须验证
}
```


```java
@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/success")
    public String successLogin(){
        return "success";
    }
    @ResponseBody
    @RequestMapping("/failure")
    public String failureLogin(){
        return "failure";
    }
}
```


### AuthorizeRequests
首先使用`antMatchers`和`anyRequest`匹配url, 然后再使用`permitAll`或`has*`来设置权限.
设置步骤如下:

1. 先设置放行页面, 不需要登录, 也不需要权限
- permitAll() 放行匹配到的url

2. 设置需要权限的页面
- hasAuthority() 拥有权限
- hasAnyRole() 拥有角色
- hasIpAddress 拥有指定ip

3. 设置需要登录的页面
- anyRequest() 任何url
- authenticated 需要登录
```java
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

```


### UserDetailService
service层实现`UserDetailsService`, 重写`loadUserByUsername`方法.
- `loadUserByUsername`的参数就是用户输入的参数
先获取用户名, 并比较
再获取密码,
再获取权限
将用户名, 密码和权限返回, Security接下来会自动比较

```java
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名去数据库查询,如果不存在抛出异常
        if(!"user".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2.用户名存在,则比较密码
        String password = passwordEncoder.encode("user"); //获得客户端传来的密码
        //3.如果相同则返回UserDetail
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("access"));
    }
}
```


`InMemoryAuthentication`