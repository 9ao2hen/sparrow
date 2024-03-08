package com.mervyn.sparrow.system.service.impl;

import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.infrastructure.SysMenuConverter;
import com.mervyn.sparrow.system.manager.SysMenuManager;
import com.mervyn.sparrow.system.model.SysMenu;
import com.mervyn.sparrow.system.service.SysMenuService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuManager manager;

    /**
     * 新增系统菜单
     *
     * @param menuDTO
     * @return
     */
    public Long createMenu(SysMenuDTO menuDTO) {
        return manager.add(menuDTO);
    }

    /**
     * 编辑系统菜单
     *
     * @param menuDTO
     * @return
     */
    public SysMenuDTO modifyMenu(SysMenuDTO menuDTO) {
        Long update = manager.update(menuDTO);
        return update != null ? menuDTO : null;
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    public Long deleteMenu(Long menuId) {
        return manager.delete(menuId);
    }

    @Override
    public Long disableMenu(Long menuId) {
        SysMenuDTO menuDTO = new SysMenuDTO();
        menuDTO.setId(menuId);
        menuDTO.setStatus(SystemEnum.CommonStatus.disable.getCode());
        return manager.update(menuDTO);
    }

    @Override
    public Long enableMenu(Long menuId) {
        SysMenuDTO menuDTO = new SysMenuDTO();
        menuDTO.setId(menuId);
        menuDTO.setStatus(SystemEnum.CommonStatus.enable.getCode());
        return manager.update(menuDTO);
    }

    @Override
    public SysMenuDTO getById(Long menuId){
        SysMenu sysMenu = manager.getById(menuId);
        return SysMenuConverter.INSTANCE.po2Dto(sysMenu);
    }

    @Override
    public List<SysMenuDTO> getByParentId(Long parentId){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(parentId);
        List<SysMenu> menuList = manager.selectMenu(sysMenu);
        return SysMenuConverter.INSTANCE.po2Dto(menuList);
    }



}
