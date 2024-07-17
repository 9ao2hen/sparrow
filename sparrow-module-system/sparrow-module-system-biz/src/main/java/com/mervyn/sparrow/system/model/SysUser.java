package com.mervyn.sparrow.system.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SysUser implements Serializable {
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
     * 状态 ‘1’：正常 ‘2’：禁用
     */
    private String status;

    /**
     * 删除状态 ‘0’正常，‘1’：删除
     */
    private Boolean deleted;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}