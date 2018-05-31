package com.pachiraframework.springcloud.message.entity;

import lombok.Data;

@Data
public class MessageTemplate {
	/**
	 * 模版ID
	 */
	private String id;
	/**
	 * 模版名称
	 */
	private String name;
	/**
	 * 模版内容
	 */
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageTemplate(String id, String name, String content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
	}
	public MessageTemplate() {
		super();
	}
	
	
	
	
	
}
