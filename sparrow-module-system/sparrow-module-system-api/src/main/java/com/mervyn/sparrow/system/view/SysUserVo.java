package com.mervyn.sparrow.system.view;

import com.mervyn.sparrow.common.data.domain.query.PageQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 2hen9ao
 * @date 2024/4/11 17:08
 */
@Setter
@Getter
public class SysUserVo extends PageQuery {

    /**
     * 用户id
     */
    private String id;

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
