package com.demo.rabbitmq.direct.producer;

import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.direct.constant.DirectConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Component
public class DirectProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage message){
        if(message == null){
            return;
        }
        if(DirectConstant.ROUTING_KEY_1.equals(message.getRoutingKey())){
            this.rabbitTemplate.convertAndSend(DirectConstant.EXCHANGE_NAME, DirectConstant.ROUTING_KEY_1, message.toString());
        }else{
            this.rabbitTemplate.convertAndSend(DirectConstant.EXCHANGE_NAME, DirectConstant.ROUTING_KEY_2, message.toString());
        }
    }

}
