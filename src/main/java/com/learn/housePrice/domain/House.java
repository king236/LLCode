package com.learn.housePrice.domain;

import java.io.Serializable;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/

import org.apache.commons.lang3.builder.ToStringBuilder;

/*@Entity*/
public class House implements Serializable{
	
	private static final long serialVersionUID = 1L;
/*	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String houseName;
	@Column(nullable=false)
	private String houseAdress;
	@Column(nullable=true)
	private String phone;
	
	public House(){
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setHouseName(String houseName){
		this.houseName = houseName;
	}
	
	public String getHouseName(){
		return this.houseName;
	}
	
	public void setHouseAdress(String adress){
		this.houseAdress = adress;
	}
	
	public String getHouseAdress(){
		return this.houseAdress;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}*/
}
