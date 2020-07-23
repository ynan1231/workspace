package cn.yn.bootdemo.redis.controller;

import cn.yn.bootdemo.durid.model.ZuanAccount;
import cn.yn.bootdemo.durid.service.AccountService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置步骤:
 * 1. 引入jar包
 * 2. 配置 host port
 * 要用cacheable需加注释@EnableCaching
 * 注意, jedis默认的序列化和反序列化工具是string
 *
 */
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/redis/get")
    public  Map<String,Object> get(){

        redisTemplate.opsForValue().set("test","123jfkjkdfknsnfms");
        Map<String,Object> result = new HashMap();
        String stringKey =  (String) redisTemplate.opsForValue().get("test");
        result.put("string",stringKey);
        result.put("set",redisTemplate.opsForSet().members("vote:userIds:1:tianyatopic-212:up"));
        result.put("list",redisTemplate.opsForList().range("vote:userList:1:tianyatopic-212:up",0,-1));
        result.put("string2",redisTemplate.opsForValue().get("user::userId314"));
        return result;
    }
    @RequestMapping(value = "/redis/{userId}")
    public ZuanAccount cacheT(@PathVariable int userId){
       return accountService.findUser_r((long) userId);
    }
}
