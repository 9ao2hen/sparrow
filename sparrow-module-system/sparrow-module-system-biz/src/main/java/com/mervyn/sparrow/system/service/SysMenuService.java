package com.mervyn.sparrow.system.service;

import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.param.MenuQuery;
import com.mervyn.sparrow.system.param.SysMenuEditReq;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/4 20:24
 */
public interface SysMenuService {
    String createMenu(SysMenuDTO menuDTO);

    SysMenuDTO modifyMenu(SysMenuEditReq editReq);

    String deleteMenu(String menuId);

    String disableMenu(String menuId);

    String enableMenu(String menuId);

    SysMenuDTO getById(Long menuId);

    List<SysMenuDTO> getByParentId(String parentId);

    List<SysMenuDTO> getAllMenu();

    PageResult<SysMenuDTO> getPage(MenuQuery query);
}
