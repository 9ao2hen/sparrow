package com.mervyn.sparrow.system.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author 2hen9ao
 * @date 2024/7/18 15:40
 */
@Getter
@Setter
public class SysMenuEditReq {

    @NotBlank(message = "id不能为空")
    private String Id;
    @NotBlank(message = "parentId不能为空")
    private String parentId;

    private String name;
    private String type;
    private String path;
    private String sort;
    private String icon;
    private String permission;
    private String component;
    private String componentName;
    private String status;

}
