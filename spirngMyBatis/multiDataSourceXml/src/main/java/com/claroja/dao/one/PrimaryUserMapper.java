package com.claroja.dao.one;

import com.claroja.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrimaryUserMapper {
    public List<User> queryUserList();
}