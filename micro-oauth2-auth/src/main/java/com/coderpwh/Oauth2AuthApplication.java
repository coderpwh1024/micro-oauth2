package com.coderpwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author coderpwh
 */

@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthApplication.class, args);
    }


}
