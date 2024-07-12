package com.coderpwh.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "authOther")
public interface OtherProviderClient {

    @GetMapping("/other/info")
    Map<String, Object> getOtherInfo(@RequestParam(value = "str",   required = false) String str);
}
