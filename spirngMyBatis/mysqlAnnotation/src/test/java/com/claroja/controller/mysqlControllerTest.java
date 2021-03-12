package com.claroja.controller;

import com.claroja.dao.UserMapper;
import com.claroja.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class mysqlControllerTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void queryUserList() {
        List<User> users = userMapper.queryUserList();
        System.out.println(users);

    }
}