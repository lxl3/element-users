package com.baizhi.elementusers.Mapper;

import com.baizhi.elementusers.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface usermapper {
    //获取所有用户
    List<user> getallUser();
    //添加用户
    void saveUser(user user);
    //删除用户
    void delete(String id);
    //修改用户
    void update(user user);
    //分页查询
    List<user> findbypage(@Param("start") Integer start,@Param("rows") Integer rows);
    //获取总记录数
    Long findallsize();
}
