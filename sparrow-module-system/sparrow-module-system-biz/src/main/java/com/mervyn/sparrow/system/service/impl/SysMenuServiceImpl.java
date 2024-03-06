package com.mervyn.sparrow.system.service.impl;

import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.mapper.SysMenuMapper;
import com.mervyn.sparrow.system.service.SysMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuMapper menuMapper;

    /**
     * 新增系统菜单
     * @param menuDTO
     * @return
     */
    public Long createMenu(SysMenuDTO menuDTO){
        //TODO
        return null;
    }

    /**
     * 编辑系统菜单
     * @param menuDTO
     * @return
     */
    public SysMenuDTO modifyMenu(SysMenuDTO  menuDTO){
        //TODO
        return null;
    }

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    public Long deleteMenu(Long menuId){
        //TODO
        return null;
    }

    public Long disableMenu(Long menuId){
        return null;
    }

}
