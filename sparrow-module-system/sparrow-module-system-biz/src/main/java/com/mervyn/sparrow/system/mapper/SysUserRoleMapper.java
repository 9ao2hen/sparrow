package com.mervyn.sparrow.system.mapper;

import com.mervyn.sparrow.system.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 2hen9ao
* @description 针对表【sys_user_role】的数据库操作Mapper
* @createDate 2024-04-19 16:00:18
* @Entity generator.com.mervyn.sparrow.system.SysUserRole
*/
@Mapper
public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole userRole);

    int insertSelective(SysUserRole userRole);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole userRole);

    int updateByPrimaryKey(SysUserRole userRole);

}
