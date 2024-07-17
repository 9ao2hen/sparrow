package com.mervyn.sparrow.common.data.domain;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/7/17 16:35
 */
public class Pages {

    public static <T> PageResult<T> of(List<T> list, Integer pageSize, Integer pageNum, Long total) {
        return new PageResult<T>(list, total, pageSize, pageNum);
    }

}
