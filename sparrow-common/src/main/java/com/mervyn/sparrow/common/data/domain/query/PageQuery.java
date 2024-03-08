package com.mervyn.sparrow.common.data.domain.query;

import java.io.Serializable;

/**
 * @author 2hen9ao
 * @date 2024/3/8 16:49
 */
public class PageQuery implements Serializable {

    private Integer pageNumber = 1;
    private Integer pageSize = 10;

    public PageQuery() {
    }

    public PageQuery(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
