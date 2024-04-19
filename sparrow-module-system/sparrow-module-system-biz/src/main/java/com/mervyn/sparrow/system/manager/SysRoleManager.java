package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.system.model.SysRole;

/**
 * @author 2hen9ao
 * @date 2024/3/6 12:56
 */
public interface SysRoleManager {

    int deleteById(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectById(Long id);

    int updateByIdSelective(SysRole record);

    int updateById(SysRole record);
}
