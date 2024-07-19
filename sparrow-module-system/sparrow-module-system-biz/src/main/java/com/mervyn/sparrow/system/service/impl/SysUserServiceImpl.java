package com.mervyn.sparrow.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.config.util.Exps;
import com.mervyn.sparrow.framework.security.token.JwtAuthenticationToken;
import com.mervyn.sparrow.framework.security.util.JwtTokenUtil;
import com.mervyn.sparrow.system.constant.SystemUserConstant;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.infrastructure.SysUserConverter;
import com.mervyn.sparrow.system.manager.SysUserManager;
import com.mervyn.sparrow.system.param.SysUserAddReq;
import com.mervyn.sparrow.system.param.SysUserQuery;
import com.mervyn.sparrow.system.security.domain.SystemUserDetails;
import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SysUserServiceImpl implements SysUserService {

//    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

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
        } catch (AuthenticationException exception) {
            log.error("登录异常:{}", exception.getMessage());
        }
        return token;
    }

    //退出登录，并且将 jwt 设置为过期
    @Override
    public String logout() {
        String token = jwtTokenUtil.getToken(SecurityContextHolder.getContext().getAuthentication());
        jwtTokenUtil.expireToken(token);
        return token;
    }


    @Override
    public String createUser(SysUserAddReq addReq) {
        String password = StrUtil.isNotBlank(addReq.getPassword()) ? addReq.getPassword() : SystemUserConstant.ADMIN_DEFAULT_PASSWORD;
        String encodePsd = passwordEncoder.encode(password);
        SysUserDTO sysUserDTO = SysUserConverter.INSTANCE.addReq2Dto(addReq);
        sysUserDTO.setPassword(encodePsd);
        Long userId = userManager.createUser(sysUserDTO);
        return userId != null ? String.valueOf(userId) : null;
    }

    @Override
    public SysUserDTO updateUser(SysUserDTO userDTO) {
        return userManager.updateUser(userDTO);
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
        new PageInfo<>(list);
        return list;
    }

    @Override
    public PageResult<SysUserDTO> getPage(SysUserQuery query) {
        return userManager.getPage(query);
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
