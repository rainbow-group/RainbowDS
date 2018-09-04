package com.rainbow.core.cache;

import java.util.Map;
import java.util.Set;

import com.rainbow.common.beans.LookupItem;

/**
 * @author Ray
 */
public class RedisCacheService implements CacheService {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<LookupItem> getCachedLookup(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<LookupItem>> getAllCachedLookups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putToken(String name, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeToken(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getToken(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getAllCachedToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putRequestToken(String token, Long reqDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getRequestToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRequestToken(String token) {
		// TODO Auto-generated method stub

	}

}
