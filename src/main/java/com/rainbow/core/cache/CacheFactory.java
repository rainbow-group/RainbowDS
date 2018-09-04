package com.rainbow.core.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Constants;
import com.rainbow.common.util.PropertiesFactory;

/**
 * @author Ray
 * 
 */

public class CacheFactory {
	final static Logger logger = LogManager.getLogger(CacheFactory.class);

	private static CacheService cacheService;
	public static Long LOGIN_TIMEOUT;

	static {
		String cacheType = PropertiesFactory.getConfig(Constants.CONFIG_PROPERTIES_CACHE_TYPE);
		String timout = PropertiesFactory.getConfig(Constants.CONFIG_PROPERTIES_LOGIN_TIMEOUT);
		if (timout != null) {
			try {
				LOGIN_TIMEOUT = Long.valueOf(timout);
				logger.info("Loing timeout after  " + LOGIN_TIMEOUT);
			} catch (NumberFormatException e) {
				LOGIN_TIMEOUT = 1000 * 60 * 60 * 24L;
				logger.info("#" + Constants.CONFIG_PROPERTIES_LOGIN_TIMEOUT + "# is not in config. ");
				logger.info("Loing timeout after  " + LOGIN_TIMEOUT + " as default.");
			}

		}

		if (Constants.CACHE_TYPE_REDIS.equalsIgnoreCase(cacheType)) {
			cacheService = new RedisCacheService();
			logger.info("Build Cache Service with " + Constants.CACHE_TYPE_REDIS);
		} else {
			if (Constants.CACHE_TYPE_LOCAL.equalsIgnoreCase(cacheType)) {
				logger.info("Build Cache Service with " + Constants.CACHE_TYPE_LOCAL);
			} else {
				logger.info("#" + Constants.CONFIG_PROPERTIES_CACHE_TYPE
						+ "# is not config or has wrong value, set Cache Service with default type "
						+ Constants.CACHE_TYPE_LOCAL);
			}
			cacheService = new LocalCacheService();
		}
	}

	public static CacheService getCache() {
		return cacheService;
	}

	public static void initCache() {
		logger.info("Init Cache Start.");
		cacheService.init();
		logger.info("Init Cache finish.");
	}

}
