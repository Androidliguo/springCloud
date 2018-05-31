package com.pachiraframework.springcloud.message.dto;

import lombok.Data;

@Data
public class SmsSendResponse {
	/**
	 * 返回消息
	 */
	private String message;
	/**
	 * 返回状态码
	 */
	private String code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public SmsSendResponse(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	public SmsSendResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
