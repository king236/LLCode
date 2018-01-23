package com.learn.housePrice.util;

public class Result {
	
	public static final Result success(String message){
		return new Result("success", message);	
	}
	
	public static final Result failure(String message){
		return new Result("error", message);
	}
	
	private String result;
	private String message;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	public Result(String result, String message){
		this.result = result;
		this.message = message;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
