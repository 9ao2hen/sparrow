package com.mervyn.sparrow.system.model;

import java.io.Serializable;

/**
 * 
 * @TableName sys_user_role
 */
public class SysUserRole implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}