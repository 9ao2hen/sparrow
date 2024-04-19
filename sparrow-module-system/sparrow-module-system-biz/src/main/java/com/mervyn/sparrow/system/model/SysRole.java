package com.mervyn.sparrow.system.model;

import java.io.Serializable;

/**
 * @TableName sys_role
 */
public class SysRole implements Serializable {
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
    private Boolean deleted;

    private static final long serialVersionUID = -632426164362948057L;

    /**
     * 角色 id
     */
    public Long getId() {
        return id;
    }

    /**
     * 角色 id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 角色标识
     */
    public String getCode() {
        return code;
    }

    /**
     * 角色标识
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 数据范围（1:全部数据权限 2:本部门以及下属部门 3:本部门 4:自定义
     */
    public String getScope() {
        return scope;
    }

    /**
     * 数据范围（1:全部数据权限 2:本部门以及下属部门 3:本部门 4:自定义
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}