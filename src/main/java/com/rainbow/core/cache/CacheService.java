package com.rainbow.core.cache;

import java.util.Map;
import java.util.Set;

import com.rainbow.common.beans.LookupItem;

/**
 * Interface for Cache Service
 * 
 * @author Ray
 */
public interface CacheService {

	public void init();

	public void clean();

	public Set<LookupItem> getCachedLookup(String name);

	public Map<String, Set<LookupItem>> getAllCachedLookups();

	public void putToken(String name, String token);

	public void removeToken(String name);

	public String getToken(String name);

	public Map<String, String> getAllCachedToken();

	public void putRequestToken(String token, Long reqDate);

	public Long getRequestToken(String token);

	public void removeRequestToken(String token);

}
