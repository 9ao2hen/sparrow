package com.mervyn.sparrow.system.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @TableName sys_role
 */
@Getter
@Setter
public class SysRoleDTO {
    /**
     * 角色 id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String code;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 数据范围（1:全部数据权限 2:本部门以及下属部门 3:本部门 4:自定义 
     */
    private String scope;

    /**
     * 状态 ‘1’：正常 ‘2’：禁用
     */
    private String status;

    /**
     * 删除状态（0正常 1删除）
     */
    private String deleted;

}