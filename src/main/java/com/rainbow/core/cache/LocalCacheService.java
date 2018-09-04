package com.rainbow.core.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rainbow.common.Constants;
import com.rainbow.common.beans.LookupItem;

/**
 * @author Ray
 */
public class LocalCacheService implements CacheService {
	final static Logger logger = LogManager.getLogger(LocalCacheService.class);

	private static Map<String, Set<LookupItem>> CACHED_LOOKUPS = new HashMap<String, Set<LookupItem>>();

	private static Map<String, String> CACHED_TOKENS = new HashMap<String, String>();

	private static Map<String, Long> CACHED_LAST_REQUEST_TOKEN = new HashMap<String, Long>();

	@Override
	public void init() {
		Set<LookupItem> testLookup = new HashSet<LookupItem>();
		CACHED_LOOKUPS.put(Constants.CACHED_LOOKUP_TEST, testLookup);
		logger.info("Init Lookup " + Constants.CACHED_LOOKUP_TEST + " Done.");

	}

	@Override
	public void clean() {
		CACHED_LOOKUPS = new HashMap<String, Set<LookupItem>>();
		CACHED_TOKENS = new HashMap<String, String>();
	}

	@Override
	public Set<LookupItem> getCachedLookup(String name) {
		return CACHED_LOOKUPS.get(name);
	}

	@Override
	public Map<String, Set<LookupItem>> getAllCachedLookups() {
		return CACHED_LOOKUPS;
	}

	@Override
	public void putToken(String name, String token) {
		CACHED_TOKENS.put(name, token);
	}

	@Override
	public void removeToken(String name) {
		CACHED_TOKENS.remove(name);
	}

	@Override
	public String getToken(String name) {
		return CACHED_TOKENS.get(name);
	}

	@Override
	public Map<String, String> getAllCachedToken() {
		return CACHED_TOKENS;
	}

	@Override
	public void putRequestToken(String token, Long reqDate) {
		CACHED_LAST_REQUEST_TOKEN.put(token, reqDate);
	}

	@Override
	public void removeRequestToken(String token) {
		CACHED_LAST_REQUEST_TOKEN.remove(token);
	}

	@Override
	public Long getRequestToken(String token) {
		return CACHED_LAST_REQUEST_TOKEN.get(token);
	}

}
