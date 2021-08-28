package com.demo.rabbitmq.work.producer;

import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.work.constant.WorkConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Component
public class WorkProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage message){
        if(message == null){
            return;
        }
        this.rabbitTemplate.convertAndSend(WorkConstant.QUEUE_NAME, message.toString());
    }

}
