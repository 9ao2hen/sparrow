package com.mervyn.sparrow.system.mapper;


import com.mervyn.sparrow.system.model.SysRole;

/**
* @author 2hen9ao
* @description 针对表【sys_role】的数据库操作Mapper
* @createDate 2024-03-04 20:15:17
* @Entity generator.com.mervyn.sparrow.system.SysRole
*/
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

}
