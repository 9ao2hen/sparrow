package com.mervyn.sparrow.system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author 2hen9ao
 * @date 2024/3/13 16:06
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        // 1.使用内存数据进行认证
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 2.创建两个用户
        UserDetails user1 = User.withUsername("baizhan").password("123").authorities("admin").build();
        UserDetails user2 = User.withUsername("sxt").password("456").authorities("admin").build();
        // 3.将这两个用户添加到内存中
        manager.createUser(user1);
        manager.createUser(user2);
        return manager;
    }
    //密码编码器，不解析密码
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

}
