package com.rabbitmq;

import java.io.IOException;
import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * receiver 必须加上@service或者其他才能被spring容器所管理
 * 我以为加了@RabbitListener就会被自动管理了，但并没有
 * 而且官方教程，也没有加。真是坑死人不偿命
 *
 * @author wenbochang
 * @date 2018年5月27日
 */
@Service
@RabbitListener(queues = RabbitBeanConf.QUEUE)
public class RabbitReceiver {
	
	/**
	 * 这里因为是接受的对象为json格式
	 * 如果想要接收后进行处理
	 * 
	 * @param msg
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * 2018年5月27日
	 */
	@RabbitHandler
	public void receive(String msg) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(msg, User.class);
		System.out.println("消费者收到了一个消息: " + user + "  " + new Date().getTime());
	}
}












