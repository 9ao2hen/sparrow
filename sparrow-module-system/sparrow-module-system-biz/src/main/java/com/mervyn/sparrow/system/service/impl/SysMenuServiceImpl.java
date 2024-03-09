package com.mervyn.sparrow.system.service.impl;

import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.common.utils.IdGenerator;
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
    @Override
    public String createMenu(SysMenuDTO menuDTO) {
        menuDTO.setId(IdGenerator.genIdStr());
        Long id = manager.add(menuDTO);
        return String.valueOf(id);
    }

    /**
     * 编辑系统菜单
     *
     * @param menuDTO
     * @return
     */
    @Override
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
    @Override
    public String deleteMenu(String menuId) {
        Long id = manager.delete(Long.getLong(menuId));
        return String.valueOf(id);
    }

    @Override
    public String disableMenu(String menuId) {
        SysMenuDTO menuDTO = new SysMenuDTO();
        menuDTO.setId(menuId);
        menuDTO.setStatus(SystemEnum.CommonStatus.disable.getCode());
        Long id = manager.update(menuDTO);
        return String.valueOf(id);
    }

    @Override
    public String enableMenu(String menuId) {
        SysMenuDTO menuDTO = new SysMenuDTO();
        menuDTO.setId(menuId);
        menuDTO.setStatus(SystemEnum.CommonStatus.enable.getCode());
        Long id = manager.update(menuDTO);
        return String.valueOf(id);
    }

    @Override
    public SysMenuDTO getById(Long menuId) {
        SysMenu sysMenu = manager.getById(menuId);
        return SysMenuConverter.INSTANCE.po2Dto(sysMenu);
    }

    @Override
    public List<SysMenuDTO> getByParentId(String parentId) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(Long.valueOf(parentId));
        List<SysMenu> menuList = manager.selectMenu(sysMenu);
        return SysMenuConverter.INSTANCE.po2Dto(menuList);
    }


}
