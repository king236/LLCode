package com.learn.housePrice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User extends BaseEntity<Long>{

    private static final long serialVersionUID = 1L;

    /**
     * 用户昵称
     */
	private String nickname;
    /**
     * 邮箱|登录帐号
     */
	private String email;
    /**
     * 密码
     */
	private String pswd;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 最后登录时间
     */
	private Date lastLoginTime;
    /**
     * 1:有效，0:禁止登录
     */
	private String status;

	private List<Role> userRoles;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", email=" + email + ", pswd=" + pswd + ", createTime="
				+ createTime + ", lastLoginTime=" + lastLoginTime + ", status=" + status + ", userRoles=" + userRoles
				+ "]";
	}
}
