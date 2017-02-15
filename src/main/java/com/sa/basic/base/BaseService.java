package com.sa.basic.base;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sa.basic.page.ModelPage;


@Service
public abstract class BaseService<T> extends BaseLogger{

    public abstract BaseDao<T> getDao();

    public boolean add(Map<String, Object> params){
    	try {
    		return this.getDao().add(params)>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    public boolean del(Map<String, Object> params){
    	try {
			return this.getDao().del(params)>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    public boolean delList(Map<String, Object> params){
    	try {
			return this.getDao().delList(params)>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean update(Map<String, Object> params){
    	try {
    		 return this.getDao().update(params)>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public boolean updateList(Map<String, Object> params){
    	try {
    		 return this.getDao().updateList(params)>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public T get(Map<String, Object> params){
        return this.getDao().get(params);
    }
    
    /**
     * 单表不分页查询,返回list
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<T> getList(Map<String, Object> params){
        return this.getDao().getList(params);
    }
    /**
     * 单表分页查询
     * @param params
     * @return
     */
    public ModelPage<T> getListPage(Map<String, Object> params){
        PageHelper.startPage(params);
        List<T> list = this.getDao().getList(params);
		return new ModelPage<T>(list, params);
    }
}