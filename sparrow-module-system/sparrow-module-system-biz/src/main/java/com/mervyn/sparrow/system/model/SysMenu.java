package com.mervyn.sparrow.system.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @TableName sys_menu
 */
@Getter
@Setter
public class SysMenu {
    /**
     * 菜单 id
     */
    private Long id;

    /**
     * 父级菜单 id
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    private String component;

    /**
     * 菜单类型 M:目录,C:菜单，F：按钮
     */
    private String type;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private String sort;

    /**
     * 状态 ‘1’：正常 ‘2’：禁用
     */
    private String status;

    /**
     * 删除状态 ‘0’正常，‘1’：删除
     */
    private Boolean deleted;

    /**
     *
     */
    private String remark;

    private Date createTime;

    private Date updateTime;

}