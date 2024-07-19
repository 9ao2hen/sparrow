package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.model.SysMenu;
import com.mervyn.sparrow.system.param.MenuQuery;

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

    PageResult<SysMenuDTO> getPage(MenuQuery query);
}
