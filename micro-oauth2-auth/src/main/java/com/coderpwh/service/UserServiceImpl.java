package com.coderpwh.service;

import cn.hutool.core.collection.CollUtil;
import com.coderpwh.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author coderpwh
 */
@Service
public class UserServiceImpl implements UserDetailsService {


    private List<UserDTO> userList;


    @Resource
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDTO(1L, "macro", password, 1, CollUtil.toList("ADMIN")));
        userList.add(new UserDTO(2L, "andy", password, 1, CollUtil.toList("TEST")));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDTO> findUserList = userList.stream().filter(item->item.getUsername().equals(username)).collect(Collectors.toList());



        return null;
    }


}
