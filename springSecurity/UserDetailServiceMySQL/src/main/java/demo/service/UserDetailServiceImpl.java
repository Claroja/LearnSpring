package demo.service;

import demo.dao.UserMapper;
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
    @Autowired
    private UserMapper userMapper;


    //这一步只是根据用户输入从数据库中获得用户信息,框架会拿到此结果在下一步进行密码的比较
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户输入的用户名,从数据库中获得用户信息,写全包名是为了和security的User类区别
        demo.model.User user = userMapper.getUserByName(username);
        //用户名不存在则
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //此步多余,测试密码没有加密所以手动加密,生产中不需要
        String password = passwordEncoder.encode(user.getPassword());
        //将userDetail返回,框架会和输入的密码进行比对
        return new User(username,password, AuthorityUtils.createAuthorityList(user.getAuthority()));
    }
}
