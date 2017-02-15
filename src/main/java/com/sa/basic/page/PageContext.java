package com.sa.basic.page;

/**
 * 描述：分页帮助类
 * @date 2016年3月24日
 * @author yzj
 * @version 1.0
 */
public class PageContext {
	
	private static ThreadLocal<Integer> pageSize;//分页的大小
	private static ThreadLocal<Integer> pageOffset;//分页的开视页
	private static ThreadLocal<String> sort;//列表的排序字段
	private static ThreadLocal<String> order;//列表的排列方式
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	public static Integer getPageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(Integer _pageOffset) {
		pageOffset.set(_pageOffset);
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		sort.set(_sort);
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		order.set(_order);
	}
	
	public static void removePageSize(){
		
		pageSize.remove();
	}
	
	public static void removePageOffset(){
		
		pageOffset.remove();
	}
	
	public static void removeSort(){
		
		sort.remove();
	}
	
	public static void removeOrder(){
		order.remove();
	}
}
