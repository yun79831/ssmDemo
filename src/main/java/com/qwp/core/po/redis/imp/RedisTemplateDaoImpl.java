package com.qwp.core.po.redis.imp;

import com.qwp.core.po.redis.RedisTemplateDao;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisTemplateDaoImpl implements RedisTemplateDao {

    private final static Logger logger = Logger.getLogger(RedisTemplateDaoImpl.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public boolean set(String key, Object value) {
        if (key == null || value == null) {
            return false;
        }
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean expire(String key, Long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public boolean expireAt(String key, Date expireDate) {
        return redisTemplate.expireAt(key, expireDate);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public boolean delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
        return true;
    }

}
