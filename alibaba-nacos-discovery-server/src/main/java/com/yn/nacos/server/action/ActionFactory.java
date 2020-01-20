/**
 * @copyright 2011 tianya.cn
 */
package com.yn.nacos.server.action;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yn.nacos.server.util.JsonResult;
import com.yn.nacos.server.util.JsonUtil;

/**
 * 服务工厂
 */
@Component
public class ActionFactory implements ApplicationContextAware {

	/**
	 * 日志实例
	 */
	private static final Logger logger = LoggerFactory.getLogger(ActionFactory.class);

	/**
	 * 通过Spring扫描加载action目录下面的接口实现类
	 */
	public static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

	/**
	 * 调用服务
	 * 
	 * @param method
	 * @param params
	 * @return
	 */
	public static String callService(String method, Map<String, Object> header, Map<String, Object> params) {

		Object service = getService(method);
		Method refMethod = null;
		try {
			int lastIndexOf = method.lastIndexOf(".");
			if (service != null && lastIndexOf >= 0) {
				refMethod = service.getClass().getMethod(method.substring(lastIndexOf + 1), Map.class, Map.class);
			}
			if (refMethod == null) {
				return JsonResult.getFailedResponse("-1", "指定的服务不存在！");
			}

		} catch (Exception e) {
			logger.error("调用服务出错！指定的服务不存在! method = " + method);
			logger.error("header:{}", JsonUtil.toJson(header));
			logger.error("params:{}", JsonUtil.toJson(params));
			return JsonResult.getFailedResponse("-1", "指定的服务不存在！");
		}

		try {
			// 调用方法
			return (String) refMethod.invoke(service, header, params);

		} catch (Exception e) {
			logger.error("调用服务出错！method = " + method, e);
			return JsonResult.getFailedResponse("-1", "调用服务出错！");
		}
	}

	/**
	 * 获取服务
	 * 
	 * @param method
	 * @return
	 */
	public static Object getService(String method) {
		Object s = null;
		try {
			s = ctx.getBean(method.substring(0, method.lastIndexOf(".")));
		} catch (Exception e) {
			logger.error("获取服务出错！method = " + method, e);
		}
		return s;
	}
}
