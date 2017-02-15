package com.sa.basic.dao;

import java.util.List;
import java.util.Map;

import com.sa.basic.base.BaseDao;
import com.sa.basic.model.ExtNode;
import com.sa.basic.model.Sys_Menu;

public interface MenuDao extends BaseDao<Sys_Menu>{
	
	List<ExtNode> getMenuNodes(Map<String, Object> params);  //获取子菜单列表
	List<Sys_Menu> getMenuList(Map<String, Object> params);

}
