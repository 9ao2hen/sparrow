package com.mervyn.sparrow.framework.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken生成的工具类  <br/>
 * JWT token的格式：header.payload.signature   <br/>
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}  <br/>
 * payload的格式（用户名、签发时间、过期时间）：
 * {"sub":"user","iat":1489079981393,"exp":1489684781}  <br/>
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 *
 * @author 2hen9ao
 * @date 2024/4/10 13:03
 */
@Component
public class JwtTokenUtil {

//    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "iat";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.token-header}")
    private String tokenHead;


    /**
     * 根据用户信息生成token
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        //todo
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否有效
     * @param token
     * @return
     */
    public boolean validateToken(String token){
        return getClaimsFromToken(token) != null || !isTokenExpired(token);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        //TODO
        return null;
    }


    public String getRefreshToken(String token) {
        //TODO
        return null;
    }


    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


    /**
     * 从token中获取荷载
     *
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
//            log.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }

    /**
     * 判断token是否过期
     *
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
}
