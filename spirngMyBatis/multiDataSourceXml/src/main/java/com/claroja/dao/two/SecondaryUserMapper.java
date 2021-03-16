package com.claroja.dao.two;

import com.claroja.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondaryUserMapper {
    public List<User> queryUserList();
}