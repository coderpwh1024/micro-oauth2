package com.coderpwh.holder;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.coderpwh.domain.UserDTO;
import org.springframework.web.server.ServerWebExchange;
import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import com.nimbusds.jose.*;

/**
 * @author coderpwh
 */
@Slf4j
@Component
public class LoginUserHolder {



    public UserDTO getCurrentUser() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        try {
            String authorization = request.getHeader("Authorization");
            log.info("Authorization:{}",authorization);

            String realToken = authorization.replace("Bearer ", "");
            JWSObject jwsObject = JWSObject.parse(realToken);
            String userStr = jwsObject.getPayload().toString();

//        String userStr = request.getHeader("user");
            JSONObject userJsonObject = new JSONObject(userStr);

            UserDTO userDTO = new UserDTO();
            userDTO.setPassword(userJsonObject.getStr("user_name"));
            userDTO.setId(Convert.toLong(userJsonObject.get("id")));
            userDTO.setRoles(Convert.toList(String.class, userJsonObject.get("authorities")));
            return userDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

}
