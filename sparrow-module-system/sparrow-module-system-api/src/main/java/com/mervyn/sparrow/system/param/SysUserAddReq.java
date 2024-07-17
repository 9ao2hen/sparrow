package com.mervyn.sparrow.system.param;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 2hen9ao
 * @date 2024/4/11 17:08
 */
@Getter
@Setter
public class SysUserAddReq {


    /**
     * 用户名
     */
    @NotBlank(message = "用户账号不能为空")
//    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
//    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    /**
     * 昵称
     */
    @Size(max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickName;

    /**
     * 用户密码
     */
    private String password;
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
     * 备注
     */
    private String remark;

}
