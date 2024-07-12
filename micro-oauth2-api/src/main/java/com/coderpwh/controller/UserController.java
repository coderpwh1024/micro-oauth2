package com.coderpwh.controller;

import com.coderpwh.domain.UserDTO;
import com.coderpwh.holder.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderpwh.client.OtherProviderClient;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author coderpwh
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Resource
    private OtherProviderClient otherProviderClient;


    @Autowired
    private LoginUserHolder loginUserHolder;


    @GetMapping(value = "/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }


    @GetMapping(value = "/test")
    public Map<String, Object> getInfo() {
        String str = "This is test";
        return    otherProviderClient.getOtherInfo(str);
    }


}
