package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.system.entity.SysUserDTO;

import java.util.List;

/**
 * @author 2hen9ao
 * @time 2024/3/6 12:57
 */
public interface SysUserManager {
    Long createUser(SysUserDTO userDTO);

    SysUserDTO updateUser(SysUserDTO userDTO);

    Integer updateStatus(Long userId, SystemEnum.CommonStatus status);

    Integer deleteUser(Long userId);

    SysUserDTO getUserById(Long userId);

    SysUserDTO getUserByUserName(String username);

    List<SysUserDTO> getList(SysUserDTO userDTO);

}
