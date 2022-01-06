package com.baizhi.elementusers.Service.impl;

import com.baizhi.elementusers.Mapper.usermapper;
import com.baizhi.elementusers.Service.Userservice;
import com.baizhi.elementusers.bean.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class userserviceImpl implements Userservice {
    @Autowired
    private usermapper usermapper;

    @Override
    public List<user> findbypage(Integer pageNow, Integer rows) {
        Integer start=(pageNow-1)*rows;
        return usermapper.findbypage(start,rows);
    }

    @Override
    public Long findallsize() {
        return usermapper.findallsize();
    }

    @Override
    public void saveUser(user user) {
        usermapper.saveUser(user);
    }

    @Override
    public void deleteuser(String id) {
        usermapper.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<user> getalluser() {
        return usermapper.getallUser();
    }

    @Override
    public void update(user user) {
        usermapper.update(user);
    }
}
