package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.system.entity.SysMenuDTO;

/**
 * @author 2hen9ao
 * @date 2024/3/6 12:56
 */
public interface SysMenuManager {
    Long add(SysMenuDTO menuDTO);

    Long update(SysMenuDTO menuDTO);

    Long delete(Long id);

    SysMenuDTO getById(Long id);
}
