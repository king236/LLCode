package com.learn.housePrice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
public class Role {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 角色名称
     */
	private String name;
    /**
     * 角色类型
     */
	private String type;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Role{" +
			", id=" + id +
			", name=" + name +
			", type=" + type +
			"}";
	}
}
