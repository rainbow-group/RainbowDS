package com.rainbow.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ray
 */
public class JsonUtil {
	final static Logger logger = LogManager.getLogger(JsonUtil.class);

	public static String getJsonStr(Object object) {
		ObjectMapper mapper = new ObjectMapper();

		String jsonStr = "";
		try {
			if (object != null) {
				jsonStr = mapper.writeValueAsString(object);
			}
		} catch (JsonProcessingException e) {
			logger.error("Json Translate Error ", e);
		}

		return jsonStr;
	}
}
