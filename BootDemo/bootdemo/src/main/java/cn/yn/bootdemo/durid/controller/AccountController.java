package cn.yn.bootdemo.durid.controller;

import cn.yn.bootdemo.durid.service.AccountService;
import cn.yn.bootdemo.durid.model.ZuanAccount;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account/{userId}")
    public String getAccount(@PathVariable int userId){
        ZuanAccount user = accountService.findUser((long) userId);
        return JSONObject.toJSONString(user);
    }
    @RequestMapping(value = "/account/w/{userId}")
    public String getAccount_w(@PathVariable int userId){
        ZuanAccount user = accountService.findUser_w((long) userId);
        return JSONObject.toJSONString(user);
    }
    @RequestMapping(value = "/account/r/{userId}")
    public String getAccount_r(@PathVariable int userId){
        ZuanAccount user = accountService.findUser_r((long) userId);
        return JSONObject.toJSONString(user);
    }
}
