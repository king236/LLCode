package com.learn.housePrice.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import com.learn.housePrice.enums.UserLoginStatus;
/*
 * Created by lilin on 17-10-23
 * 用户Entity
 */
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nickName;
	private String email;
	private String pswd;
	private Date createTime;
	private Date lastLoginTime;
	private UserLoginStatus status;

	public UserEntity() {
		super();
	}

	public UserEntity(String nickName, String pswd, String email) {
		super();
		this.nickName = nickName;
		this.pswd = pswd;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public UserLoginStatus getStatus() {
		return status;
	}

	public void setStatus(UserLoginStatus status) {
		this.status = status;
	}

}
