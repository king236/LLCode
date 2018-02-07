package com.learn.housePrice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class BaseEntity<ID> implements Serializable{
	private static final long serialVersionUID = -457238698078138858L;
	
	@TableId(value="id", type= IdType.AUTO)
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
		
}
