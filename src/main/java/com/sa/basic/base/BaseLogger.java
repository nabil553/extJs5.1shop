package com.sa.basic.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：Log基类,所有的类默认继承此类,可以直接使用 logger 记录日志,例如 logger.error("error");
 * @date 2016年4月20日 下午5:10:56
 * @author zss
 * @version 1.0
 */
public abstract class BaseLogger {
	public Logger logger = LoggerFactory.getLogger(getClass());
}
