package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.model.SysMenu;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/6 12:56
 */
public interface SysMenuManager {
    Long add(SysMenuDTO menuDTO);

    Long update(SysMenuDTO menuDTO);

    Long delete(Long id);

    SysMenu getById(Long id);

    List<SysMenu> selectMenu(SysMenu menu);

    List<SysMenu> getMenuByRole(String roleId);
}
