package com.rainbow.core.cache.redis;

import redis.clients.jedis.Jedis;

public class RedisFactory {
	public static void set(String key, String value) {

		Jedis jedis = RedisPoolUtil.getJedis();
		try {
			jedis.set(key, value);
		} finally {
			jedis.close();
		}
	}

	public static String get(String key) {

		Jedis jedis = RedisPoolUtil.getJedis();
		String value = null;
		try {
			value = jedis.get(key);
		} finally {
			jedis.close();
		}

		return value;
	}
}
