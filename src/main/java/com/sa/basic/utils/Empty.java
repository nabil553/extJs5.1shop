package com.sa.basic.utils;

import java.util.Collection;
import java.util.Map;
/**
 * 描述：工具类，验证对象是否为空
 * @date 2016年5月14日 上午9:02:51
 * @author yzj
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class Empty {

	//检验object对象为空
	public static boolean isEmpty(Object obj) {
		if(obj==null) return true;
		if(obj instanceof String) {
			if("".equals(obj)) return true;
		}
		if(obj instanceof Collection<?>) {
			if(((Collection) obj).size()>0) return true;
		}
		return false;
	}
	
	//检验object对象不为空
	public static boolean isNotEmpty(Object obj) {
		if(obj==null) return false;
		if(obj instanceof String) {
			if("".equals(obj)) return false;
		}
		if(obj instanceof Collection<?>) {
			if(((Collection) obj).size()>0) return true;
		}
		return false;
	}
	
	//检验Map中key对应的value对象为空
	public static boolean isEmpty(Map<String, Object> map, String key){
		Object value = map.get(key);
		if(value==null || String.valueOf(value).trim().equals(""))
		return true;
		else return false;
	}
	
	//检验Map中key对应的value对象不为空
	public static boolean isNotEmpty(Map<String, Object> map, String key){
		Object value = map.get(key);
		if(value==null || String.valueOf(value).trim().equals(""))
		return false;
		else return true;
	}
	
	//检验String对象为空
	public static boolean isEmpty(String value){
		if(value==null || value.trim().equals(""))
		return true;
		else return false;
	}
	//检验String对象不为空
	public static boolean isNotEmpty(String value){
		if(value==null || value.trim().equals(""))
		return false;
		else return true;
	}
	
}
