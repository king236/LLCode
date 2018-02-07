package com.learn.housePrice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lilin
 * @since 2017-11-13
 */
@TableName("u_role")
public class Role extends BaseEntity<Long>{

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
	private String name;
    /**
     * 角色类型
     */
	@TableField("role_key")
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
