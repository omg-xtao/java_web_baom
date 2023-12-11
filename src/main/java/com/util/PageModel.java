package com.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author xtaod
 */
public class PageModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int pageSize;		//每页显示的记录数
    private final int pageNo;			//当前页次
    private final int recordCount;		//记录总数
    private final int pageCount;			//分页总数
    private final List<T> data;			//当前页记录集列表
    private String pageNav;			//翻页导航的HTML实现

    public PageModel(int pageSize, int pageNo, List<T> data) {
        if(pageSize < 1){
            this.pageSize = 10;
        }else {
            this.pageSize = pageSize;
        }
        this.recordCount = data.size();
        this.pageCount = (recordCount + this.pageSize - 1) / this.pageSize;
        if(pageNo < 1){
            this.pageNo = 1;
        }else {
            this.pageNo = Math.min(pageNo, this.pageCount);
        }
        int fromIndex = (this.pageNo - 1) * this.pageSize;
        int toIndex = Math.min(this.pageNo * this.pageSize, this.recordCount);
        this.data = data.subList(fromIndex, toIndex);
    }

    public void setPageNav(String url){
        if(url.lastIndexOf('?') != - 1){
            url += "&";
        }else{
            url += "?";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("共&nbsp;").append(recordCount).append("&nbsp;条&nbsp;&nbsp;");
        sb.append(pageSize).append("&nbsp;条/页&nbsp;&nbsp;");
        if (pageNo >= 2) {
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(1).append("&pageSize=").append(pageSize);
            sb.append("'>首页</a>&nbsp;&nbsp;");
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(pageNo-1).append("&pageSize=");
            sb.append(pageSize).append("'>上一页</a>&nbsp;&nbsp;");
        } else {
            sb.append("首页&nbsp;&nbsp;");
            sb.append("上一页&nbsp;&nbsp;");
        }
        if (pageNo < pageCount && pageCount != 0) {
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(pageNo+1).append("&pageSize=");
            sb.append(pageSize).append("'>下一页</a>&nbsp;&nbsp;");
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(pageCount).append("&pageSize=");
            sb.append(pageSize).append("'>尾页</a>&nbsp;&nbsp;");
        } else {
            sb.append("下一页&nbsp;&nbsp;");
            sb.append("尾页&nbsp;&nbsp;");
        }
        sb.append("跳转到第&nbsp;").append("<select>");
        for(int i = 1; i <= pageCount; i++){
            if(pageNo != i){
                sb.append("<option onclick=\"location.href='").append(url);
                        sb.append("pageNo=").append(i);
            }else {
                sb.append("<option selected='selected' onclick=\"location.href='");
                        sb.append(url).append("pageNo=").append(i);
            }
            sb.append("&pageSize=").append(pageSize).append("';\">");
            sb.append("&nbsp;").append(i).append("/").append(pageCount);
            sb.append("&nbsp;").append("</option>");
        }
        sb.append("</select>&nbsp;页");
        this.pageNav = sb.toString();
    }

    public List<T> getData() {
        return data;
    }

    public String getPageNav() {
        return pageNav;
    }
}
