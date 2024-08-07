package com.mervyn.sparrow.system.service.impl;

import com.mervyn.sparrow.system.manager.SysRoleManager;
import com.mervyn.sparrow.system.service.SysRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Resource
    SysRoleManager roleManager;

    public Integer disableRole(String roleId) {
        return roleManager.disableRole(roleId);
    }

    public Integer deleteRole(String roleId) {
        return roleManager.deleteById(Long.valueOf(roleId));
    }

    /**
     * 获取角色的所有菜单
     */
    public String getRoleMenu(String roleId) {
        //todo 获取角色的所有菜单

        return null;
    }




}
