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
public class UserRole implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private Long uid;
    /**
     * 角色ID
     */
	private Long rid;


	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
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
