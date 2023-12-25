package com.util;

import com.entity.Grade;
import com.entity.Record;
import com.entity.Reginfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author xtaod
 */
public class PageModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageSize;        //每页显示的记录数
    private int pageNo;            //当前页次
    private int recordCount;        //记录总数
    private int pageCount;            //分页总数
    private List<Record> data;            //当前页记录集列表
    private List<Reginfo> data2;
    private List<Grade> data3;

    private String pageNav;            //翻页导航的HTML实现
    private int fromIndex;
    private int toIndex;

    public void init(int pageSize, int pageNo, int size) {
        if (pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
        this.recordCount = size;
        this.pageCount = (recordCount + this.pageSize - 1) / this.pageSize;
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = Math.min(pageNo, this.pageCount);
        }
        this.fromIndex = (this.pageNo - 1) * this.pageSize;
        if (this.fromIndex < 0) {
            this.fromIndex = 0;
        }
        this.toIndex = Math.min(this.pageNo * this.pageSize, this.recordCount);
        if (this.toIndex > size) {
            this.toIndex = size;
        }
    }

    public PageModel(int pageSize, int pageNo, List<Record> data) {
        init(pageSize, pageNo, data.size());
        this.data = data.subList(this.fromIndex, this.toIndex);
    }

    public PageModel(int pageSize, int pageNo, Object o, List<Reginfo> data2) {
        init(pageSize, pageNo, data2.size());
        this.data = null;
        this.data2 = data2.subList(this.fromIndex, this.toIndex);
    }

    public PageModel(int pageSize, int pageNo, Object o, Object o2, List<Grade> data3) {
        init(pageSize, pageNo, data3.size());
        this.data = null;
        this.data3 = data3.subList(this.fromIndex, this.toIndex);
    }

    public void setPageNav(String url) {
        if (url.lastIndexOf('?') != -1) {
            url += "&";
        } else {
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
            sb.append("pageNo=").append(pageNo - 1).append("&pageSize=");
            sb.append(pageSize).append("'>上一页</a>&nbsp;&nbsp;");
        } else {
            sb.append("首页&nbsp;&nbsp;");
            sb.append("上一页&nbsp;&nbsp;");
        }
        if (pageNo < pageCount && pageCount != 0) {
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(pageNo + 1).append("&pageSize=");
            sb.append(pageSize).append("'>下一页</a>&nbsp;&nbsp;");
            sb.append("<a href='").append(url);
            sb.append("pageNo=").append(pageCount).append("&pageSize=");
            sb.append(pageSize).append("'>尾页</a>&nbsp;&nbsp;");
        } else {
            sb.append("下一页&nbsp;&nbsp;");
            sb.append("尾页&nbsp;&nbsp;");
        }
        sb.append("跳转到第&nbsp;").append("<select onchange=\"record('");
        sb.append(url).append("',").append("this.value,");
        sb.append(pageSize).append(");\">");
        for (int i = 1; i <= pageCount; i++) {
            if (pageNo != i) {
                sb.append("<option>");
            } else {
                sb.append("<option selected='selected'>");
            }
            sb.append("&nbsp;").append(i).append("/").append(pageCount);
            sb.append("&nbsp;").append("</option>");
        }
        sb.append("</select>&nbsp;页");
        this.pageNav = sb.toString();
    }

    public List<Record> getData() {
        return data;
    }

    public List<Reginfo> getData2() {
        return data2;
    }

    public List<Grade> getData3() {
        return data3;
    }

    public String getPageNav() {
        return pageNav;
    }

    public int getFromIndex() {
        return fromIndex;
    }
}
