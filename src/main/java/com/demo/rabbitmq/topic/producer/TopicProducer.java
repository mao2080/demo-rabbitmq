package com.demo.rabbitmq.topic.producer;

import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.topic.constant.TopicConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Component
public class TopicProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage message){
        if(message == null){
            return;
        }
        this.rabbitTemplate.convertAndSend(TopicConstant.EXCHANGE_NAME, message.getRoutingKey(), message.toString());
    }

}
