package com.coderpwh.service;

import cn.hutool.core.collection.CollUtil;
import com.coderpwh.constant.RedisConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author coderpwh
 */

@Service
public class ResourceServiceImpl {


    private Map<String, List<String>> resourceRolesMap;


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public  void initData(){

        resourceRolesMap =   new TreeMap<>();
        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        resourceRolesMap.put("/api/user/test", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }




}
