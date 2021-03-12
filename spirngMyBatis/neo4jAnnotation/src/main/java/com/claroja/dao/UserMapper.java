package com.claroja.dao;

import com.claroja.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("match(n:Person) return n.title as title,n.name as name")
    public List<User> queryUserList();
}