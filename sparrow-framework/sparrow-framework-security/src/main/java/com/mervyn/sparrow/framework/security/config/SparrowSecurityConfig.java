package com.mervyn.sparrow.framework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author 2hen9ao
 * @date 2024/3/18 17:18
 */
@Configuration
@EnableWebSecurity
public class SparrowSecurityConfig {


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->
                        registry.requestMatchers(HttpMethod.OPTIONS).permitAll()
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling(exceptionHandling -> exceptionHandling.configure())
        ;
        return http.build();
    }
}
