package com.mervyn.sparrow.system.service.impl;

import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.manager.SysUserManager;
import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserManager userManager;

    @Override
    public String createUser(SysUserDTO userDTO) {
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
    public List<SysUserDTO> getList(SysUserDTO userDTO) {
        List<SysUserDTO> list = userManager.getList(userDTO);
        return list;
    }
}
