package com.learn.housePrice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("u_permission")
public class Permission extends BaseEntity<Long>{

    private static final long serialVersionUID = 1L;

	@TableField("permission_name")
	private String permissionName;
	@TableField("permission_url")
	private String permissionUrl;
	@TableField("permission_key")
	private String permissionKey;
	@TableField("parent_id")
	private Long parentId;
	@TableField("permission_type")
	private String permissionType;
	private Long sort;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String getPermissionKey() {
		return permissionKey;
	}

	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionName=" + permissionName + ", permissionUrl=" + permissionUrl
				+ ", permissionKey=" + permissionKey + ", parentId=" + parentId + ", permissionType=" + permissionType
				+ ", sort=" + sort + "]";
	}
	
	
}
