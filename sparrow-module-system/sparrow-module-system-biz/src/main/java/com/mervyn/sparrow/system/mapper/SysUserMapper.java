package com.mervyn.sparrow.system.mapper;


import com.mervyn.sparrow.system.model.SysUser;
import com.mervyn.sparrow.system.param.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 2hen9ao
 * @description 针对表【sys_user】的数据库操作Mapper
 * @createDate 2024-03-11 13:51:33
 * @Entity generator.com.mervyn.sparrow.system.SysUser
 */
@Mapper
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectList(SysUser user);

    List<SysUser> selectPage(SysUserQuery user);

    SysUser selectByUsername(String username);
}
