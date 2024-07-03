package com.coderpwh.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author coderpwh
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class ResourceServerConfig {


    private final AuthenticationManager authenticationManager;

    private  final  IgnoreUrlsConfig ignoreUrlsConfig;


}
