package com.sa.basic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述：菜单资源实体类
 * @date 2016年5月9日 上午11:04:01
 * @author zss
 * @version 1.0
 */
@Entity
@Table(name = "T_LEFT")
@SuppressWarnings({ "unused" })
public class Sys_Menu extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	private Integer nodeid; // <NODEID> 主键
	
	private String parentid;	// <PARENTID> 父菜单ID
	
	private String mytext;	// <MYTEXT> 菜单名称
	
	private String location;	// <LOCATION>  节点ID，树节点中的id
	
	private Integer orderId;	// <ORDER_ID> 排序值
	
	private String window;	// <WINDOW>  url地址
	
	private String fm;	// <FM>
	
	private String wTarget;	// <W_TARGET> 窗口名称
	
	private String iconGif;	// <ICON_GIF> 图标地址

	public Integer getNodeid() {
		return this.getInteger("nodeid");	
	}

	public void setNodeid(Integer nodeid) {
		this.set("nodeid", nodeid);
	}

	public String getParentid() {
		return this.getString("parentid");
	}

	public void setParentid(String parentid) {
		this.set("parentid", parentid);
	}

	public String getMytext() {
		return this.getString("mytext");
	}

	public void setMytext(String mytext) {
		this.set("mytext", mytext);
	}

	public String getLocation() {
		return this.getString("location");
	}

	public void setLocation(String location) {
		this.set("location", location);
	}

	public Integer getOrderId() {
		return this.getInteger("orderId");
	}

	public void setOrderId(Integer orderId) {
		this.set("orderId", orderId);
	}

	public String getWindow() {
		return this.getString("window");
	}

	public void setWindow(String window) {
		this.set("window", window);
	}

	public String getFm() {
		return this.getString("fm");
	}

	public void setFm(String fm) {
		this.set("fm", fm);
	}

	public String getwTarget() {
		return this.getString("wTarget");
	}

	public void setwTarget(String wTarget) {
		this.set("wTarget", wTarget);
	}

	public String getIconGif() {
		return this.getString("iconGif");
	}

	public void setIconGif(String iconGif) {
		this.set("iconGif", iconGif);
	}
}
