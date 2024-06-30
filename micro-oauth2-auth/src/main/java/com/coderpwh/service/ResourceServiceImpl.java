package com.coderpwh.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author coderpwh
 */

@Service
public class ResourceServiceImpl {


    private Map<String, List<String>> resourceRolesMap;


    @Resource
    private RedisTemplate<String, Object> redisTemplate;




}
