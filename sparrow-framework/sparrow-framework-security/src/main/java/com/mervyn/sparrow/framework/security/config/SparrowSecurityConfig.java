package com.mervyn.sparrow.framework.security.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/test/error").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(restAuthenticationEntryPoint).accessDeniedHandler(restfulAccessDeniedHandler))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}
