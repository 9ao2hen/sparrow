package com.mervyn.sparrow.system.mapper;

import com.mervyn.sparrow.system.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 2hen9ao
* @description 针对表【sys_role_menu】的数据库操作Mapper
* @createDate 2024-04-19 16:00:11
* @Entity generator.com.mervyn.sparrow.system.SysRoleMenu
*/
@Mapper
public interface SysRoleMenuMapper {

    int deleteById(Long id);

    int insert(SysRoleMenu roleMenu);

    int insertSelective(SysRoleMenu roleMenu);

    SysRoleMenu selectById(Long id);

    int updateByIdSelective(SysRoleMenu roleMenu);

    int updateById(SysRoleMenu roleMenu);

    List<SysRoleMenu> getMenuByRoleId(Long roleId);


}
