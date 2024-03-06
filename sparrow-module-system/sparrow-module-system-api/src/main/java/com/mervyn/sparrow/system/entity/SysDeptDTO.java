package com.mervyn.sparrow.system.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SysDeptDTO implements Serializable {
    /**
     * 部门 id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}