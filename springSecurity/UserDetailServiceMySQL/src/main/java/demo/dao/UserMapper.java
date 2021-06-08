package demo.dao;

import demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> queryUserList();

    @Select("select * from user where username = #{username}")
    public User getUserByName(String username);
}
