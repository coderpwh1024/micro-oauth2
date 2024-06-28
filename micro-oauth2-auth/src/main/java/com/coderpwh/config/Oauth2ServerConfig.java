package com.coderpwh.config;

import com.coderpwh.component.JwtTokenEnhancer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author coderpwh
 */

@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {


    private  final PasswordEncoder passwordEncoder;

    private  final AuthenticationManager authenticationManager;

    private  final JwtTokenEnhancer jwtTokenEnhancer;
}
