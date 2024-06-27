package com.coderpwh.controller;

import com.coderpwh.domain.UserDTO;
import com.coderpwh.holder.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderpwh
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private LoginUserHolder loginUserHolder;


    @GetMapping(value = "/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }


}
