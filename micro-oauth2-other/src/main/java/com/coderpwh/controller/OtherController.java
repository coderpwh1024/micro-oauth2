package com.coderpwh.controller;


import cn.hutool.json.JSONUtil;
import com.coderpwh.domain.UserDTO;
import com.coderpwh.holder.LoginUserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/other")
public class OtherController {


    @Autowired
    private LoginUserHolder loginUserHolder;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Map<String, Object> getOtherInfo(String str) {
        UserDTO userDTO = loginUserHolder.getCurrentUser();
        log.info("user信息为:{}", JSONUtil.toJsonStr(userDTO));

        Map<String,Object> map = new HashMap<>();
        map.put("id",userDTO.getId());
        map.put("str",str);
        return  map;
    }

}
