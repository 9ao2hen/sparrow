package com.mervyn.sparrow.system.mapper;


import com.mervyn.sparrow.system.model.SysDept;

/**
* @author 2hen9ao
* @description 针对表【sys_dept】的数据库操作Mapper
* @createDate 2024-03-04 20:15:17
* @Entity generator.com.mervyn.sparrow.system.SysDept
*/
public interface SysDeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

}
