package self.family.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class PageVO<T> implements Serializable{

    private static final long serialVersionUID = 3488157026088557510L;
    /**
     * 查询结果集
     */
    private List<T> rows;
    /**
     * 总条数
     */
    private Integer count;
    /**
     * 总页数
     */
    private Integer total;
    /**
     * 每页显示数量
     */
    private Integer limit;
    /**
     * 第几页
     */
    private Integer page;

    /**
     * 起始查询位置
     */
    private Integer offset;

    public PageVO() {
        setRows(new ArrayList<T>());
    }

    public PageVO(List<T> rows, Integer count, Integer total, Integer limit, Integer page, Integer offset) {
        this.rows = rows;
        this.count = count;
        this.total = total;
        this.limit = limit;
        this.page = page;
        this.offset = offset;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        this.total = ((Double)Math.ceil((this.count * 1.00)/this.limit)).intValue();
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.offset = (page-1) * limit;
    }

    public Integer getOffset() {
        return offset;
    }

}
