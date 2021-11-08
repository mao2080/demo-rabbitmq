package com.demo.rabbitmq.sample.producer;

import com.demo.rabbitmq.sample.constant.SampleConstant;
import com.demo.rabbitmq.beans.DemoMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mao2080@sina.com
 */
@Component
public class SampleProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DemoMessage message){
        if(message == null){
            return;
        }
        this.rabbitTemplate.convertAndSend(SampleConstant.QUEUE_NAME, message.toString());
    }

}
