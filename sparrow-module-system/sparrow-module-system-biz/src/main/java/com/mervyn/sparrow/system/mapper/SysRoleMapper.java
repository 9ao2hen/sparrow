package com.mervyn.sparrow.system.mapper;

import com.mervyn.sparrow.system.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 2hen9ao
 * @createDate 2024-04-19 14:34:00
 */
@Mapper
public interface SysRoleMapper {

    int deleteById(Long id);

    int insert(SysRole sysRole);

    int insertSelective(SysRole sysRole);

    SysRole selectById(Long id);

    int updateByIdSelective(SysRole sysRole);

    int updateById(SysRole sysRole);

    List<SysRole> getList(SysRole sysRole);




}
