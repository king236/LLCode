package com.learn.housePrice.entity;

import java.io.Serializable;

public class Role extends BaseEntity<Long>{

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
	private String name;
    /**
     * 角色类型
     */
	private String roleKey;
	
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", roleKey=" + roleKey + ", status=" + status + "]";
	}

	
}
