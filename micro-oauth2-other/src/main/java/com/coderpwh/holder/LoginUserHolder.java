package com.coderpwh.holder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.coderpwh.domain.UserDTO;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;

/**
 * @author coderpwh
 */
@Component
public class LoginUserHolder {



    public UserDTO getCurrentUser() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);

        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toLong(userJsonObject.get("id")));
        userDTO.setRoles(Convert.toList(String.class, userJsonObject.get("authorities")));
        return userDTO;
    }

}
