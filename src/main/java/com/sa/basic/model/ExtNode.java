package com.sa.basic.model;

import org.springframework.stereotype.Component;

/**
 * 描述：ExtJS项目中通用节点模型,无对应数据表,用于生成树形控件,ExtJS项目中使用该节点模型
 * @date 2016年3月25日
 * @author zss
 * @version 1.0
 */
@Component
@SuppressWarnings({ "unused" })
public class ExtNode extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private String id;	// 节点的id	
	
	private String text;	// 节点显示文本
	
	private String parentid;	//节点父id
	
	private String icon; // 图标地址
	
	private Integer orderId;	//排序值
	
	private String url; // 节点url
	
	private String parentText; //父节点文本
	
	private boolean leaf;	//节点是否是父节点
	
	private Integer childCount; //子节点数量，如果值为0，则leaf值为true

	public String getId() {
		return this.getString("id");
	}

	public void setId(String id) {
		this.set("id", id);
	}

	public String getText() {
		return this.getString("text");
	}

	public void setText(String text) {
		this.set("text", text);
	}

	public String getParentid() {
		return this.getString("parentid");
	}

	public void setParentid(String parentid) {
		this.set("parentid", parentid);
	}

	public String getIcon() {
		return this.getString("icon");
	}

	public void setIcon(String icon) {
		this.set("icon", icon);
	}

	public Integer getOrderId() {
		return this.getInteger("orderId");
	}

	public void setOrderId(Integer orderId) {
		this.set("orderId", orderId);
	}

	public String getUrl() {
		return this.getString("url");
	}

	public void setUrl(String url) {
		this.set("url", url);
	}

	public String getParentText() {
		return this.getString("parentText");
	}

	public void setParentText(String parentText) {
		this.set("parentText", parentText);
	}

	public boolean isLeaf() {
		return this.getBoolean("leaf");
	}

	public void setLeaf(boolean leaf) {
		this.set("leaf", leaf);
	}

	public Integer getChildCount() {
		return this.getInteger("childCount");
	}

	public void setChildCount(Integer childCount) {
		this.set("childCount", childCount);
	}


}
