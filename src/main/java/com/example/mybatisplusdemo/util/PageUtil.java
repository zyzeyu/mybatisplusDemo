package com.example.mybatisplusdemo.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * TODO
 *
 * @author qinzh
 * @version 1.0
 * @date 2022/11/22 22:11
 */
public class PageUtil {
    public static <T> PageInfo<T> getPageInfo(List<T> list, int pageNum, int pageSize) {
        int total = list.size();
        int pages = (int) Math.ceil((double) total / pageSize);

        PageInfo<T> pageInfo = new PageInfo<>();
        // 总条数
        pageInfo.setTotal(total);
        // 页大小
        pageInfo.setPageSize(pageSize);
        // 总页数
        pageInfo.setPages(pages);
        // 当前页
        pageInfo.setPageNum(pageNum);
        if (pageNum > pages) {
            pageNum = pages;
            pageInfo.setPageNum(pageNum);
        }
        // 开始索引
        int fromIndex = (pageNum - 1) * pageSize;
        // 结束索引
        int toIndex = pageNum * pageSize;
        if (toIndex > total) {
            toIndex = total;
        }
        // 结果集
        pageInfo.setList(list.subList(fromIndex, toIndex));
        // 当前页的条数
        pageInfo.setSize(toIndex - fromIndex);
        // 是否是第一页
        pageInfo.setIsFirstPage(pageNum == 1);
        // 是否是最后一页
        pageInfo.setIsLastPage(pageNum == pages);
        // 是否有上一页
        pageInfo.setHasPreviousPage(pageNum >= 2 && pageNum <= pages);
        // 是否有下一页
        pageInfo.setHasNextPage(pageNum <= pages - 1);
        // 上一页页码
        pageInfo.setPrePage(pageNum == 1 ? 1 : pageNum - 1);
        // 下一页页码
        pageInfo.setNextPage(pageNum >= pages ? pageNum : pageNum + 1);

        return pageInfo;
    }

}
