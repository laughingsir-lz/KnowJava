package com.lz.ssm.qo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zzz
 */

@Setter
public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 3;
    private String keyword;

    public int getStart() {
        return (currentPage - 1) * pageSize;
    }

    public String getKeyword() {
        return (keyword == null ? null : keyword.replaceAll(" ", ""));
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }
}
