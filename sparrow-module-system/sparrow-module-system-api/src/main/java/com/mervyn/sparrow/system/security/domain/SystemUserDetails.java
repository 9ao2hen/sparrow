package com.mervyn.sparrow.system.security.domain;

import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户信息封装类
 */
public class SystemUserDetails implements UserDetails {
    //后台用户
    private final SysUserDTO sysUser;
    //拥有资源列表
    private final List<SysMenuDTO> menuList;

    public SystemUserDetails(SysUserDTO sysUser, List<SysMenuDTO> menuList) {
        this.sysUser = sysUser;
        this.menuList = menuList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户所拥有的资源
        return menuList.stream()
                .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getStatus().equals(SystemEnum.CommonStatus.enable.getCode());
    }
}
