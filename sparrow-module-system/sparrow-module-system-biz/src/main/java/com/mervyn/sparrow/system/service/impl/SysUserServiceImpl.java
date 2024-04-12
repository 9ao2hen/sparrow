package com.mervyn.sparrow.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.config.util.Exps;
import com.mervyn.sparrow.framework.security.JwtAuthenticationToken;
import com.mervyn.sparrow.framework.security.util.JwtTokenUtil;
import com.mervyn.sparrow.system.constant.SystemUserConstant;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.manager.SysUserManager;
import com.mervyn.sparrow.system.security.domain.SystemUserDetails;
import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    SysUserManager userManager;
    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    JwtTokenUtil jwtTokenUtil;


    @Override
    public String login(String username, String password) {
        String token = "";
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                Exps.fail("密码错误");
            }
            if (!userDetails.isEnabled()) {
                Exps.fail("帐号已被禁用");
            }
            JwtAuthenticationToken authentication = new JwtAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            //TODO log
        } catch (AuthenticationException exception) {
            log.error("登录异常:{}", exception.getMessage());
            System.out.println("登录异常:" + exception.getMessage());
            exception.printStackTrace();
        }
        return token;
    }

    @Override
    public String createUser(SysUserDTO userDTO) {
        String password = StrUtil.isNotBlank(userDTO.getPassword()) ? userDTO.getPassword() : SystemUserConstant.ADMIN_DEFAULT_PASSWORD;
        String encodePsd = passwordEncoder.encode(password);
        userDTO.setPassword(encodePsd);
        Long userId = userManager.createUser(userDTO);
        return userId != null ? String.valueOf(userId) : null;
    }

    @Override
    public SysUserDTO updateUser(SysUserDTO userDTO) {
        SysUserDTO sysUserDTO = userManager.updateUser(userDTO);
        return sysUserDTO;
    }

    @Override
    public Integer enableUser(String userId) {
        return userManager.updateStatus(Long.valueOf(userId), SystemEnum.CommonStatus.enable);
    }

    @Override
    public Integer disableUser(String userId) {
        return userManager.updateStatus(Long.valueOf(userId), SystemEnum.CommonStatus.disable);
    }


    @Override
    public Integer deleteUser(String userId) {
        return userManager.deleteUser(Long.valueOf(userId));
    }

    @Override
    public SysUserDTO getUserById(String userId) {
        return userManager.getUserById(Long.valueOf(userId));
    }

    @Override
    public SysUserDTO getUserByUserName(String username) {
        return userManager.getUserByUserName(username);
    }

    @Override
    public List<SysUserDTO> getList(SysUserDTO userDTO) {
        List<SysUserDTO> list = userManager.getList(userDTO);
        return list;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        SysUserDTO sysUser = getUserByUserName(username);
        if (sysUser != null) {
            //TODO
//            List<SysMenuDTO> menuList = getResourceList(admin.getId());
            List<SysMenuDTO> menuList = new ArrayList<>();
            return new SystemUserDetails(sysUser, menuList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }


}
