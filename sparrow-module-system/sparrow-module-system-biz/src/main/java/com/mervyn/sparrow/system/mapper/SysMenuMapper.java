package com.mervyn.sparrow.system.mapper;

import com.mervyn.sparrow.system.model.SysMenu;
import com.mervyn.sparrow.system.param.MenuQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 2hen9ao
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2024-03-04 20:15:17
* @Entity generator.com.mervyn.sparrow.system.SysMenu
*/
@Mapper
public interface SysMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectList(SysMenu param);

    List<SysMenu> selectPage(MenuQuery param);

    List<SysMenu> getListByIds(List<Long> ids);

    SysMenu getByCode(String path);
}
