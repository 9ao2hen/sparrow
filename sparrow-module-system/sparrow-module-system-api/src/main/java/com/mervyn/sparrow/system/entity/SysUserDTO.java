package com.mervyn.sparrow.system.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @TableName sys_user
 */
@Getter
@Setter
public class SysUserDTO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 1:男，2:女
     */
    private String gender;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private Boolean status;

    /**
     * 
     */
    private Boolean deleted;

}