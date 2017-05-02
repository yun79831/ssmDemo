package com.qwp.core.po.redis;

import java.util.Date;

public interface RedisTemplateDao
{

	boolean set(String key, Object value);

	Object get(String key);

	boolean expire(String key, Long timeout);

	boolean expireAt(String key, Date expireDate);

	boolean hasKey(String key);
	
	boolean delete(String key);
}
