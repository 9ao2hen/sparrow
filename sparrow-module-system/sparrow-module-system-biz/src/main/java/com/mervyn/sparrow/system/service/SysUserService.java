package com.mervyn.sparrow.system.service;

import com.mervyn.sparrow.system.entity.SysUserDTO;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
public interface SysUserService {

    String createUser(SysUserDTO userDTO);

    SysUserDTO updateUser(SysUserDTO userDTO);

    Integer enableUser(String userId);

    Integer disableUser(String userId);

    Integer deleteUser(String userId);

    SysUserDTO getUserById(String userId);

    List<SysUserDTO> getList(SysUserDTO userDTO);
}
