package com.sa.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sa.basic.base.BaseController;
import com.sa.basic.service.MenuService;
import com.sa.basic.utils.Empty;

/**
 * 描述：登录成功后，主页面控制器
 * @date 2016年5月14日 下午1:57:29
 * @author zss
 * @version 1.0
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	
	@Resource
	private MenuService menuService;
	
	Map<String, Object> result;
	
	//获取左侧panel下的tree
	@RequestMapping("/getLeftPanelTree")
	public @ResponseBody String getLeftPanelTree(@RequestParam Map<String, Object> params, HttpSession session){
		result = new HashMap<String, Object>();
		result.put("nodeList", menuService.getMenuNodes(params));
		System.err.println(JSON.toJSONString(result));
		System.out.println(result);
		return JSON.toJSONString(result);
	}
	
	//获取左侧panel
	@RequestMapping("/getLeftPanel")
	public @ResponseBody  String getLeftPanel(@RequestParam Map<String, Object> params, HttpSession session){
		result = new HashMap<String, Object>();
		if(Empty.isEmpty(params,"parentid")) params.put("parentid", "0_");
		result.put("list", menuService.getMenuList(params));
		System.out.println(result);
		return JSON.toJSONString(result);
		
	}

}
