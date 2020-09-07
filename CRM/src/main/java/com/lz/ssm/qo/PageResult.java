package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zzz
 */
@Getter
@Setter
@ToString
public class PageResult<T> {
    private int currentPage;
    private int pageSize;
    private int totalCount;
    private List<T> list;
    private int prevPage;
    private int nextPage;
    private int totalPage;

    public PageResult(int currentPage, int pageSize, int totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = data;
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 <= 1 ? 1 : this.currentPage - 1;
        this.nextPage = this.currentPage + 1 >= this.totalPage ? this.totalPage : this.currentPage + 1;
    }
}
