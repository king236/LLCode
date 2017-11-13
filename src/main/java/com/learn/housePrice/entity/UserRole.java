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
@TableName("u_user_role")
public class UserRole {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private String uid;
    /**
     * 角色ID
     */
	private String rid;


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "UserRole{" +
			", uid=" + uid +
			", rid=" + rid +
			"}";
	}
}
