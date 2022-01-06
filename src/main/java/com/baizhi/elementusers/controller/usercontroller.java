package com.baizhi.elementusers.controller;

import com.alibaba.druid.util.StringUtils;
import com.baizhi.elementusers.Service.Userservice;
import com.baizhi.elementusers.bean.user;
import com.baizhi.elementusers.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
@CrossOrigin
public class usercontroller {
    @Autowired
    private Userservice userservice;
    @GetMapping("pagefind")
    public Map<String,Object> findbypage(Integer pageNow, Integer pageSize){
        pageNow=pageNow==null? 1:pageNow;
        pageSize=pageSize==null? 4:pageSize;
        Map<String,Object> result=new HashMap<>();
        List<user> users = userservice.findbypage(pageNow, pageSize);
        result.put("user",users);
        Long totals = userservice.findallsize();
        result.put("total",totals);
        return result;
    }
    @GetMapping("getall")
    public List<user> getall(){
        System.out.println(userservice.getalluser());
        return userservice.getalluser();
    }
    @PostMapping("saveorupdate")
    public Result saveorupdate(@RequestBody  user user){
        Result result = new Result();
        if(StringUtils.isEmpty(user.getId())){
            try{
                userservice.saveUser(user);
                result.setResult(true);
                result.setMsg("添加成功");
            }catch (Exception e){
                result.setResult(false);
                result.setMsg("服务器出现错误，请稍后在试");
            }
        }else{
            try{
                userservice.update(user);
                result.setResult(true);
                result.setMsg("修改成功");
            }catch (Exception e){
                result.setResult(false);
                result.setMsg("服务器出现错误，请稍后在试");
            }
        }


        return result;

    }
    @GetMapping("delete")
    public Result delete(String id){
        Result result = new Result();
        try{
            userservice.deleteuser(id);
            result.setMsg("删除成功");
        }catch (Exception e){
            result.setResult(false);
            result.setMsg("抱歉！！！，服务器错误，请稍后再试");
        }
        return result;
    }
}
