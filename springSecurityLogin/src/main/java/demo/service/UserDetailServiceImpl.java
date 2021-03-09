package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名去数据库查询,如果不存在抛出异常
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2.用户名存在,则比较密码
        String password = passwordEncoder.encode("123"); //获得客户端传来的密码
//        password.matches();//比较数据库查询密码和客户端密码是否相同
        //3.如果相同则返回UserDetail

        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
