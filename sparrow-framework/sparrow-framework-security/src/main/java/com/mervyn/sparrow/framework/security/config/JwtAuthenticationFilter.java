package com.mervyn.sparrow.framework.security.config;

import com.mervyn.sparrow.framework.security.JwtAuthenticationToken;
import com.mervyn.sparrow.framework.security.util.JwtTokenUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author 2hen9ao
 * @date 2024/4/8 15:50
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.token-header}")
    String TOKEN_HEADER ;

    @Value("${jwt.token-prefix}")
    String TOKEN_PREFIX;

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getHeaderToken(request);

        if (token != null && jwtTokenUtil.validateToken(token)) {
            String username = jwtTokenUtil.getUserNameFromToken(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(username, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }

    private String getHeaderToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER);
        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            return token.replace(TOKEN_PREFIX, "");
        }
        return token;
    }
}
