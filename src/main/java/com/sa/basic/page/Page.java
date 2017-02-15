/**
 *备注：
 *@author yzj
 *@date 2016年3月24日
 *@version 1.0
 */
package com.sa.basic.page;

import java.util.List;

/**
 * 描述：分页模块，提供mybatis分页支持
 * @date 2016年3月24日
 * @author yzj
 * @version 1.0
 */
public class Page<T> {
private int size;	//分页的大小
	
	private int offset; //当前页
	
	private int total; //总记录数
	
	private List<T> datas;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	

}
