package com.mervyn.sparrow.system.param;


import com.mervyn.sparrow.common.data.domain.query.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 2hen9ao
 * @date 2024/4/11 17:08
 */
@Getter
@Setter
public class SysUserQuery extends PageQuery {

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

    private String status;


}
