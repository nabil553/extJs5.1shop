package com.sa.basic.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
		
	public Integer add(Map<String, Object> map);   //增加,单记录
	public Integer addList(Map<String, Object> map);	//批量增加
	public Integer update(Map<String, Object> map);	//修改,单记录
	public Integer updateList(Map<String, Object> map);	//批量修改
	public Integer del(Map<String, Object> map);	//删除,单记录
	public Integer delList(Map<String, Object> map);	//批量删除
	public T get(Map<String, Object> map);	//查询,单记录
	public List<T> getList(Map<String, Object> map);	//批量查询

}
