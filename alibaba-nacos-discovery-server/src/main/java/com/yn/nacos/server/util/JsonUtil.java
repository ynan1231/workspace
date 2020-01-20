package com.yn.nacos.server.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static JsonFactory jsonFactory = new JsonFactory();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static {
		jsonFactory.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		jsonFactory.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	}
	private static ObjectMapper mapper = new ObjectMapper(jsonFactory);

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static JsonFactory getJsonFactory() {
		return jsonFactory;
	}

	public static <T> T toBean(String json, Class<T> clazz) {
		T rtv = null;
		try {
			rtv = mapper.readValue(json, clazz);
		} catch (Exception ex) {
			throw new IllegalArgumentException("json字符串转成java bean异常", ex);
		}
		return rtv;
	}

	public static String toJson(Object bean) {
		String rtv = null;
		try {
			mapper.setDateFormat(sdf);
			rtv = mapper.writeValueAsString(bean);
		} catch (Exception ex) {
			throw new IllegalArgumentException("java bean转成json字符串异常", ex);
		}
		return rtv;
	}

	public static <T> T toBean(String json, TypeReference<T> refer) {
		if (StringUtil.isNullOrBlank(json)) {
			throw new IllegalArgumentException("json can not null");
		}
		T entity = null;
		try {
			entity = mapper.readerFor(refer).readValue(json);
		} catch (Exception e) {
			throw new IllegalArgumentException("json字符串转成java bean异常", e);
		}
		return entity;
	}

	public static <T> List<T> toBeanList(String json, Class<T> clazz) {
		if (StringUtil.isNullOrBlank(json)) {
			throw new IllegalArgumentException("json can not null");
		}
		List<T> result = null;
		try {
			JsonNode jn = mapper.readTree(json);
			result = new ArrayList();
			if (jn.isArray()) {
				Iterator<JsonNode> iter = jn.iterator();
				while (iter.hasNext()) {
					parseBeanAddToList((JsonNode) iter.next(), result, clazz);
				}
			} else {
				parseBeanAddToList(jn, result, clazz);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("json字符串转成java List<bean>异常", e);
		}
		return result;
	}

	private static <T> void parseBeanAddToList(JsonNode js, List<T> list, Class<T> clazz) throws JsonParseException,
			JsonMappingException, IOException {
		T rtv = mapper.readValue(js.toString(), clazz);
		list.add(rtv);
	}
}
