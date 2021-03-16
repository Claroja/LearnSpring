package com.claroja.controller;

import com.claroja.dao.one.PrimaryUserMapper;
import com.claroja.dao.two.SecondaryUserMapper;
import com.claroja.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class mysqlControllerTest {
    @Autowired
    private PrimaryUserMapper primaryUserMapper1;
    @Autowired
    private SecondaryUserMapper secondaryUserMapper;
    @Test
    void queryUserList() {
        List<User> users = primaryUserMapper1.queryUserList();
        System.out.println(users);

        List<User> users2 = secondaryUserMapper.queryUserList();
        System.out.println(users2);
    }
}