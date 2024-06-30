package com.coderpwh.config;

import com.sun.org.apache.bcel.internal.generic.FADD;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author coderpwh
 */

@Data
@EqualsAndHashCode(callSuper =false)
@Component
@ConfigurationProperties(prefix = "secure.ignore")
public class IgnoreUrlsConfig {

    List<String> urls;
}
