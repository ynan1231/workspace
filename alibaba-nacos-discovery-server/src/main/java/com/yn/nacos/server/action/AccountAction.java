package com.yn.nacos.server.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yn.nacos.server.service.AccountService;
import com.yn.nacos.server.util.JsonUtil;
@Service("zuan.account")

public class AccountAction {
	
	Logger logger = LoggerFactory.getLogger(AccountAction.class);
	
	@Resource(name="service.account")
	private AccountService accountService;
	@SentinelResource("hello")
	public String getAccount(Map<String, Object> header, Map<String, Object> params) throws Exception {
		int userId = MapUtils.getIntValue(params, "userId");
		return JsonUtil.toJson(accountService.selectByPrimaryKey(userId));
	}

}
