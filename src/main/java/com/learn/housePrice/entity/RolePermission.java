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
@TableName("u_role_permission")
public class RolePermission {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
	private String rid;
    /**
     * 权限ID
     */
	private String pid;


	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Override
	public String toString() {
		return "RolePermission{" +
			", rid=" + rid +
			", pid=" + pid +
			"}";
	}
}
