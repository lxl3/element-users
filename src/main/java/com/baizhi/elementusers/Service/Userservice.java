package com.baizhi.elementusers.Service;


import com.baizhi.elementusers.bean.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Userservice {
    List<user> getalluser();
    void saveUser(user user);
    void deleteuser(String id);


    void update(user user);
    //分页查询
    List<user> findbypage(Integer pageNow,  Integer pagesize);
    //获取总记录数
    Long findallsize();
}
