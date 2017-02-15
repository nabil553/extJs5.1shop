package com.sa.sys.model;

import org.springframework.stereotype.Component;

import com.sa.basic.model.BaseEntity;

@Component
@SuppressWarnings("unused")

public class Sys_User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String adminId;  // <ADMIN_ID> 表中主键
	
	private String adminName;  //<ADMIN_NAME>管理员名称
	
	private String adminPwd;  //<ADMIN_PWD>管理员密码
	
	private int state; //<STATE> 1--正常，  0--禁用
	
	private  String roleName;   //<ROLE_NAME>管理员角色名称
	
	private long sort; //<SORT> 排序值

	public String getAdminId() {
		return getString("adminId");
	}

	public void setAdminId(String adminId) {
		this.set("adminId", adminId);
	}

	public String getAdminName() {
		return getString("adminName");
	}

	public void setAdminName(String adminName) {
		this.set("adminName", adminName);
	}

	public String getAdminPwd() {
		return getString("adminPwd");
	}

	public void setAdminPwd(String adminPwd) {
		this.set("adminPwd", adminPwd);
	}

	public int getState() {
		return getInteger("state");
	}

	public void setState(int state) {
		this.set("state", state);
	}

	public String getRoleName() {
		return getString("roleName");
	}

	public void setRoleName(String roleName) {
		this.set("roleName", roleName);
	}

	public long getSort() {
		return getLong("sort");
	}

	public void setSort(long sort) {
		this.set("sort", sort);
	}
	
	
}
