package com.demo.rabbitmq.deadletter.producer;

import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.deadletter.constant.DeadLetterConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Slf4j
@Component
public class DeadLetterProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage demoMessage){
        if(demoMessage == null){
            return;
        }
        this.rabbitTemplate.convertAndSend(DeadLetterConstant.EXCHANGE_NAME_FROM, DeadLetterConstant.ROUTING_KEY_FROM, demoMessage.toString(), message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setExpiration(DeadLetterConstant.EXPIRATION_TIME);
            return message;
        });
    }

}
