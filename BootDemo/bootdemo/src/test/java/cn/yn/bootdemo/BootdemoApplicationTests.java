package cn.yn.bootdemo;

import cn.yn.bootdemo.durid.model.ZuanAccount;
import cn.yn.bootdemo.durid.service.AccountService;
import cn.yn.bootdemo.mq.SendService;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootdemoApplicationTests {
	@Autowired
	AccountService accountService;
	@Autowired
	SendService sendService;
	@Test
	void contextLoads() {
	}
	@Test
	public void test() {
		ZuanAccount user_r = accountService.findUser_r(314L);
		System.out.println(JSONObject.toJSON(user_r));
	}
	@Test
	public  void  send(){
		sendService.send();
	}

}
