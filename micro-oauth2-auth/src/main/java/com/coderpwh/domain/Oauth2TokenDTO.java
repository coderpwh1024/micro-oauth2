package com.coderpwh.domain;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author coderpwh
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDTO {


    /***
     * 令牌
     */
    private String token;


    /***
     * token刷新
     */
    private String refreshToken;

    /***
     * 访问令牌前缀
     */
    private String tokenHead;


    /***
     * 有效时间
     */
    private int expiresIn;


}
