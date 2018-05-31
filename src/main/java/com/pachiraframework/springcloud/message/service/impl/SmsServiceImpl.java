package com.pachiraframework.springcloud.message.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pachiraframework.springcloud.message.dao.MessageTemplateDao;
import com.pachiraframework.springcloud.message.dto.SmsSendRequest;
import com.pachiraframework.springcloud.message.dto.SmsSendResponse;
import com.pachiraframework.springcloud.message.entity.MessageTemplate;
import com.pachiraframework.springcloud.message.service.SmsService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
	
	private static final Logger logger=Logger.getLogger(SmsServiceImpl.class);
	@Autowired
	private MessageTemplateDao messageTemplateDao;
	@Autowired
	private Configuration configuration;
	@Override
	@SneakyThrows
	public SmsSendResponse send(SmsSendRequest request) {
		MessageTemplate messageTemplate = messageTemplateDao.get(request.getTemplateId());
		String templateContent = messageTemplate.getContent();
		Template template;
		try {
			template = new Template(request.getTemplateId(), new StringReader(templateContent), configuration);
			StringWriter out = new StringWriter();
			template.process(request.getParams(), out);
			String content = out.toString();
			return doSend(request.getMobile(), content);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//改成调用实际的短息网关发送消息
	private SmsSendResponse doSend(String mobile,String content) {
		SmsSendResponse response = new SmsSendResponse();
		response.setCode("200");
		response.setMessage("发送成功");
		logger.info("发送完毕，手机号："+mobile);
		logger.info("发送完毕，发送内容："+content);
		logger.info("发送完毕，状态码："+response.getCode());
		return response;
	}
}
