package com.sa.basic.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sa.basic.base.BaseDao;
import com.sa.basic.dao.MenuDao;
import com.sa.basic.base.BaseService;
import com.sa.basic.model.ExtNode;
import com.sa.basic.model.Sys_Menu;

@Service
public class MenuService extends BaseService<Sys_Menu>{
	
	@Resource
	private MenuDao menuDao;
	
	public List<Sys_Menu> getMenuList(Map<String, Object> params){
		return menuDao.getMenuList(params);
	}
	
	
	public List<ExtNode> getMenuNodes(Map<String, Object> params){
		List<ExtNode> nodeList = menuDao.getMenuNodes(params); 
		for(ExtNode node : nodeList){
			if(node.getInteger("childCount")>0) node.setLeaf(false);
			else node.setLeaf(true);
		}
		return nodeList;
	}


	@Override
	public BaseDao<Sys_Menu> getDao() {
		return menuDao;
	}

}
