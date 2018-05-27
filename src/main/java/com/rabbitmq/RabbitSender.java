package com.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {

	@Autowired
	AmqpTemplate amqpTemplate;
	
	public void send(String msg) {
		amqpTemplate.convertAndSend(RabbitBeanConf.QUEUE, msg);
		System.out.println("生产者生产了一个消息： " + msg + "  " + new Date().getTime());
	}
}





