package com.pachiraframework.springcloud.message.dto;

import java.util.Map;

import lombok.Data;

/**
 * 发送sms消息对象
 * @author wangxuzheng
 *
 */
@Data
public class SmsSendRequest {
	/**
	 * 短信模版ID
	 */
	private String templateId;
	/**
	 * 要发送的手机号
	 */
	private String mobile;
	/**
	 * 模版中携带的参数信息
	 */
	private Map<String, Object> params;
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	public SmsSendRequest(String templateId, String mobile,
			Map<String, Object> params) {
		super();
		this.templateId = templateId;
		this.mobile = mobile;
		this.params = params;
	}
	public SmsSendRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
