package com.mervyn.sparrow.system.param;

import com.mervyn.sparrow.common.data.domain.query.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 2hen9ao
 * @date 2024/3/8 16:39
 */
@Getter
@Setter
public class MenuQuery extends PageQuery {

    private Long id;
    private Long parentId;

    private String name;
    private String type;
    private String permission;
    private String status;

}
