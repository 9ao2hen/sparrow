package com.mervyn.sparrow.system.service;

import com.mervyn.sparrow.system.entity.SysMenuDTO;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
public interface SysMenuService {
    String createMenu(SysMenuDTO menuDTO);

    SysMenuDTO modifyMenu(SysMenuDTO menuDTO);

    String deleteMenu(String menuId);

    String disableMenu(String menuId);

    String enableMenu(String menuId);

    SysMenuDTO getById(Long menuId);

    List<SysMenuDTO> getByParentId(String parentId);
}
