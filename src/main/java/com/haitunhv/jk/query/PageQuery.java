package com.haitunhv.jk.query;

import lombok.Data;

import java.util.List;


/**
 * @Author: haitunhv
 * @Date: 2021/5/9 22:09
 */
@Data
public class PageQuery<T> {
    private static final int DEFAULT_SIZE = 10;

    private long page;
    private long size;

    private long pages;
    private long count;
    private List<T> data;

    public long getPage(){
        return Math.max(1,page);
    }
    public long getSize() {
        return (size < 1) ? DEFAULT_SIZE : size;
    }
}
