package com.itqf.entity;

import java.util.List;

public class PageBean<T> {
    private List<T> list;
    private int startRow;//起始行
    private long totalRows;//总行数
    private int pageIndex;//页码
    private int pageSize;//页大小
    private int totalPage;//总页数

    public PageBean(List<T> list, int pageIndex, int pageSize,long totalRows) {
        this.list = list;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {

        return (totalRows % pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
