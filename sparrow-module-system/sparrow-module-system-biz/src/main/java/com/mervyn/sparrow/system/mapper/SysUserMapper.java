package com.mervyn.sparrow.system.mapper;


import com.mervyn.sparrow.system.model.SysUser;

/**
* @author 2hen9ao
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2024-03-04 20:15:17
* @Entity generator.com.mervyn.sparrow.system.SysUser
*/
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

}
