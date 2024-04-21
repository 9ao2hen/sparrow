package com.mervyn.sparrow.system.manager;

import com.mervyn.sparrow.system.entity.SysRoleDTO;
import com.mervyn.sparrow.system.model.SysRole;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/6 12:56
 */
public interface SysRoleManager {

    int deleteById(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRoleDTO selectById(Long id);

    int updateByIdSelective(SysRole record);

    int updateById(SysRole record);

    List<SysRoleDTO> getRoleList(SysRole role);
}
