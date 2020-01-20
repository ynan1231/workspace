package com.yn.nacos.client.action;

import javax.websocket.server.PathParam;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.tianya.zuan.component.ZuanService;
import cn.tianya.zuan.component.util.JsonRequest;

@Controller("")
public class AccountDubboAction {
	/**
	 * failover：重试其它provider的服务  ---------  幂等时才能使用（比如读操作）
		failfast：直接返回失败				---------  一般的写操作，不能重试
		failsafe：忽略错误					---------  无关紧要的服务使用，如打日志/发邮件

	 */
	@Reference(check=false,cluster="failfast")
	private ZuanService zuanService;
	
	@RequestMapping(value = "/account/get/{userId}",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAccount(@PathVariable int userId) {
		
		JsonRequest request = JsonRequest.newInstance();
		request.setMethod("zuan.account.getAccount");
		request.setParams("userId", userId);
		
		String result =  zuanService.executeMethod(request.toJson());
		String address = RpcContext.getServerContext().getRemoteAddressString();
		String address1 = RpcContext.getServerContext().getLocalAddressString();
		String local =  RpcContext.getContext().getRemoteAddressString();
		String local1 =  RpcContext.getContext().getLocalAddressString();
		return local +local1+ address +address1+result;
	}
	
}
