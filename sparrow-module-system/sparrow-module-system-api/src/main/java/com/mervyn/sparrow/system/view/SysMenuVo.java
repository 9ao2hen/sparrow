package com.mervyn.sparrow.system.view;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 2hen9ao
 * @date 2024/3/8 16:39
 */
@Getter
@Setter
public class SysMenuVo {

    private String id;
    private String parentId;

    private String name;
    private String type;
    private String sort;
    private String icon;
    private String permission;
    private String component;
    private String componentName;
    private String status;

}
