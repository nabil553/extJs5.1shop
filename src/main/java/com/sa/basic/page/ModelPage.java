package com.sa.basic.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
/**
 * 描述：分页模型类
 * @date 2016年3月24日
 * @author yzj
 * @version 1.0
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ModelPage<T> implements Serializable {
	
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"

    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    //第一页
    private int firstPage;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //最后一页
    private int lastPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    
    //物理分页标示
    private boolean isLogic;

    //额外的参数
	Map<String, Object> params;
	
	public ModelPage(List<T> list,Map<String, Object> params) {
		this(list, 8);
		this.params = params;
    }
    
	/**
     * 包装Page对象
     *
     * @param list
     */
    public ModelPage(List<T> list) {
        this(list, 8);
    }
    
    /**
     * 物理分页
     * 包装Page对象
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public ModelPage(List<T> list, int pageNum,int pageSize) {
    	
    	this.pageNum = pageNum;
    	this.pageSize = pageSize;
    	this.total = list.size();
        if (pageSize > 0) {
            this.pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
        	this.pages = 0;
        }
    	
        List<T> pageList = new ArrayList<T>();
        if(this.total > 0){
        	this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
            this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
            if(this.endRow > total) this.endRow = ((int)this.total);
        	for(int i=this.startRow;i<this.endRow;i++){
        		pageList.add(list.get(i));
        	}
        }
        this.list = pageList;
    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public ModelPage(List<T> list, int navigatePages) {
        if (list instanceof Page) {
         
			Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
            //由于结果是>startRow的，所以实际的需要+1
            if (this.size == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else {
                this.startRow = page.getStartRow() + 1;
                //计算实际的endRow（最后一页的时候特殊）
                this.endRow = this.startRow - 1 + this.size;
            }
            this.navigatePages = navigatePages;
            //计算导航页
            calcNavigatepageNums();
            //计算前后页，第一页，最后一页
            calcPage();
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        //当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            firstPage = navigatepageNums[0];
            lastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSize() {
        return size;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public long getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public List<T> getList() {
        return list;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }
    
    public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public boolean isLogic() {
		return isLogic;
	}

	public void setIsLogic(boolean isLogic) {
		this.isLogic = isLogic;
	}

	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", startRow=").append(startRow);
        sb.append(", endRow=").append(endRow);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", firstPage=").append(firstPage);
        sb.append(", prePage=").append(prePage);
        sb.append(", nextPage=").append(nextPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", hasPreviousPage=").append(hasPreviousPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", navigatePages=").append(navigatePages);
        sb.append(", navigatepageNums=");
        if (navigatepageNums == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < navigatepageNums.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(navigatepageNums[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }

}
