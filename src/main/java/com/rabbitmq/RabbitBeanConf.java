package com.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置rabbit bean的配置文件
 * 
 * 如果要传输对象bean，那必须进行序列化的指定
 * 但指定的序列化方法我在官方文档却找不见，源码也找不到，这还是百度到的。。。
 * 这里用的是jackson序列化为json
 *
 * @author wenbochang
 * @date 2018年5月27日
 */
@Configuration
public class RabbitBeanConf {
	
	public static final String QUEUE = "queue";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE, true);
	}
	
	/**
	 * 这个配不配都行，只要配下面的MessageConverter即可
	 * @param connectionFactory
	 * @param messageConverter
	 * @return
	 * 2018年5月27日
	 
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        System.out.println("RabbitTemplate");
        return template;
    }
*/
	
    @Bean
    public MessageConverter messageConverter() {
    	System.out.println("MessageConverter");
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter());
    }
}
























