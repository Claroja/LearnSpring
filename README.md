
# springSecurity
1.security工程在导入依赖之后会自动启动,载入默认配置访问网站任何链接都需要登录.
用户名是:user
密码是:看控制台输出


2.自定义登录逻辑(用户验证)
1)添加登录逻辑service,登录逻辑需要实现UserDetailsService的loadUserByUsername方法.
方法中可以实现用户的查询,比较和授权,最终返回的是UserDetails接口的实现.
这里我们就可以自定义用户名和密码了.
2)在config包中注入了加密算法BCryptPasswordEncoder


3.自定义登录逻辑2(登录界面)
1)http.formLogin()来定义登录界面