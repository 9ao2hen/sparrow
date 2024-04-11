package com.mervyn.sparrow.system.security;

import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 2hen9ao
 * @date 2024/4/11 09:41
 */
@Service
public class SparrowUserDetailService implements UserDetailsService {

    @Resource
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return sysUserService.loadUserByUsername(username);
    }
}
