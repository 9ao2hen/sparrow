package com.mervyn.sparrow.system.service;

import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.param.SysUserAddReq;
import com.mervyn.sparrow.system.param.SysUserQuery;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
public interface SysUserService {

    String login(String username, String password);

    //退出登录，并且将 jwt 设置为过期
    String logout();

    String createUser(SysUserAddReq addReq);

    SysUserDTO updateUser(SysUserDTO userDTO);

    Integer enableUser(String userId);

    Integer disableUser(String userId);

    Integer deleteUser(String userId);

    SysUserDTO getUserById(String userId);

    SysUserDTO getUserByUserName(String username);

    List<SysUserDTO> getList(SysUserDTO userDTO);

    PageResult<SysUserDTO> getPage(SysUserQuery query);

    UserDetails loadUserByUsername(String username);
}
