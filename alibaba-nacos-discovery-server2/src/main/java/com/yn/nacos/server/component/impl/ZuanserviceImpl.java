package com.yn.nacos.server.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yn.nacos.server.action.ActionFactory;
import com.yn.nacos.server.util.JsonResult;
import com.yn.nacos.server.util.JsonUtil;
import com.yn.nacos.server.util.StringUtil;

import cn.tianya.zuan.component.ZuanService;

@Service
public class ZuanserviceImpl implements ZuanService {
	
	private Logger logger = LoggerFactory.getLogger(ZuanserviceImpl.class);

	@Override
	public String executeMethod(String jsonParams) {
		//
		if (jsonParams == null) {
			return JsonResult.getFailedResponse("-1", "请求参数不能为null。");
		}
		String remoteHost = RpcContext.getContext().getRemoteHost();//调用方IP
		int remotePort = RpcContext.getContext().getRemotePort();
		
		String application = RpcContext.getContext().getUrl().getParameter("application");//当前服务配置信息
		
		
		System.out.println(RpcContext.getContext().getLocalPort()+application+"收到"+remoteHost+":"+remotePort+"请求:"+jsonParams);
		
		try {
			Map<String, Object> requestMap = JsonUtil.toBean(jsonParams, Map.class);
			String method = (String) requestMap.get("method");
			if (StringUtil.isNullOrBlank(method)) {
				return JsonResult.getFailedResponse("-112", "请求方法名称为空！");
			}

			Map<String, Object> header = (Map<String, Object>) requestMap.get("header");
			if (header == null) {
				header = new HashMap<String, Object>();
			}
			/*
			 * String clientIP = IceIpUtil.getRequestIp(__current); if
			 * (!AccessControler.whiteListCheck(clientIP)) {
			 * logger.error("收到来自"+clientIP+"的非法请求:"+jsonParams); return
			 * JsonResult.getFailedResponse("-1", "非法IP请求."); }
			 */
			// 获取请求客户端IP
			header.put("clientIP", "");

			//
			Map<String, Object> params = (Map<String, Object>) requestMap.get("params");

			//
			String result = ActionFactory.callService(method, header, params);
				logger.info("收到请求"+jsonParams);
	            logger.info("结果"+result);
			return result;
		} catch (Exception e) {
			logger.error("【天涯钻ICE】调用公共接口发生异常！request=" + jsonParams, e);
			return JsonResult.getFailedResponse("600001", "服务请求出错！");
		}
	}

}
