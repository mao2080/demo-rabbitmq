package com.demo.rabbitmq.fanout.producer;

import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.fanout.constant.FanoutConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Component
public class FanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage message){
        if(message == null){
            return;
        }
        this.rabbitTemplate.convertAndSend(FanoutConstant.EXCHANGE_NAME, FanoutConstant.ROUTING_KEY, message.toString());
    }

}
