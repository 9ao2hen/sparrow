package com.mervyn.sparrow.framework.security.config;

import com.mervyn.sparrow.framework.security.filter.JwtAuthenticationFilter;
import com.mervyn.sparrow.framework.security.hadler.RestAuthenticationEntryPoint;
import com.mervyn.sparrow.framework.security.hadler.RestfulAccessDeniedHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/18 17:18
 */
@Configuration
@EnableWebSecurity
public class SparrowSecurityConfig {

    @Resource
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Resource
    RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Resource
    JwtAuthenticationFilter jwtAuthenticationFilter;
    @Resource
    IgnoreUrlsConfig ignoreUrlsConfig;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        忽略 url
        List<String> urls = ignoreUrlsConfig.getUrls();

        http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->authorize
                        .requestMatchers("/test/error").permitAll()
//                      .requestMatchers(urls.toArray(new String[0])).permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(restAuthenticationEntryPoint).accessDeniedHandler(restfulAccessDeniedHandler))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}
