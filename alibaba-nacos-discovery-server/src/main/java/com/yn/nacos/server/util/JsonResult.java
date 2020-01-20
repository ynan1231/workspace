package com.yn.nacos.server.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
	public static String getFailedResponse(String code, String message) {
		String response = null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put("success", Integer.valueOf(0));
			responseMap.put("code", code);
			responseMap.put("message", message);
			responseMap.put("data", map);
			response = toJson(responseMap);
		} catch (Exception localException) {
		}
		return response;
	}

	public static String getSuccessResponse(String code, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		return getSuccessResponse(code, message, map);
	}

	public static String getSuccessResponse(String code, String message, Object data) {
		String response = null;
		try {
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put("success", Integer.valueOf(1));
			responseMap.put("code", code);
			responseMap.put("message", message);
			if (data==null) {
				data = new HashMap<String, Object>();
			}
			responseMap.put("data", data);
			response = toJson(responseMap);
		} catch (Exception localException) {
		}
		return response;
	}

	public static <T> T toBean(String json, Class<T> clazz) {
		return (T) JsonUtil.toBean(json, clazz);
	}

	public static String toJson(Object bean) {
		return JsonUtil.toJson(bean);
	}
}
