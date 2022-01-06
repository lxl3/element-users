package com.baizhi.elementusers;

import com.baizhi.elementusers.Service.Userservice;
import com.baizhi.elementusers.bean.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.List;

@SpringBootTest
class ElementUsersApplicationTests {
    @Autowired
    private Userservice userservice;
    @Test
    public void testupdate(){
        user user = new user("3", "小红", "liyue", "女", new Date());
        userservice.update(user);
    }
    @Test
    void contextLoads() {
    }
    @Test
    public void testDelete(){
        userservice.deleteuser("2");

    }
    @Test
    public void testgetall(){
        List<user> users = userservice.getalluser();
        System.out.println(users);
    }
    @Test
    public void testAdd(){
        user user = new user();
        user.setName("小明");
        user.setSex("男");
        user.setAddress("北京朝阳");
        user.setBirt(new Date());
        userservice.saveUser(user);
    }

}
