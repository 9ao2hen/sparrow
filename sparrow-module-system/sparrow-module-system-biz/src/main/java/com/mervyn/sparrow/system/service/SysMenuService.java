package com.mervyn.sparrow.system.service;

import com.mervyn.sparrow.system.entity.SysMenuDTO;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
public interface SysMenuService {
    Long createMenu(SysMenuDTO menuDTO);

    SysMenuDTO modifyMenu(SysMenuDTO menuDTO);

    Long deleteMenu(Long menuId);

    Long disableMenu(Long menuId);

    Long enableMenu(Long menuId);

    SysMenuDTO getById(Long menuId);

    List<SysMenuDTO> getByParentId(Long parentId);
}
