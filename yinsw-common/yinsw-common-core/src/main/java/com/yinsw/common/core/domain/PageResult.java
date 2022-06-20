package com.yinsw.common.core.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 张凡
 * @Classname PageResult
 * @Description TODO
 * @Date 2022/2/14 19:38
 */
public class PageResult <T> implements Serializable {

    private long total;

    private List<T> list;

    public PageResult(){

    }

    public PageResult(long total, List<T> list){
        this.total = total;
        this.list = list;
    }

    public static <T> PageResult<T> toPageResult(long total,List<T> list) {return new PageResult(total,list);}

    public static <T> R<PageResult<T>> toResult(long total,List<T> list){
        return R.ok(PageResult.toPageResult(total,list));
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
