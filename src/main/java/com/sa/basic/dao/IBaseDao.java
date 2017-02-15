package com.sa.basic.dao;

/**
 * 公共的dao
 * @author ztej13
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	
	public T add(T t);
	public void update(T t);
	public void delete(T t);
	public T load(int id);
	
	

}
