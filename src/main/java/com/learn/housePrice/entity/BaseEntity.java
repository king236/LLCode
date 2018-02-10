package com.learn.housePrice.entity;

import java.io.Serializable;

public class BaseEntity<ID> implements Serializable{
	private static final long serialVersionUID = -457238698078138858L;

	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
		
}
