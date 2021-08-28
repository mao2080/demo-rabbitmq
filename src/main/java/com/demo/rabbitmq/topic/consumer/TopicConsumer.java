package com.demo.rabbitmq.topic.consumer;

import com.demo.rabbitmq.topic.constant.TopicConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author mao2080@sina.com
 */
@Slf4j
@Component
public class TopicConsumer {

    @RabbitListener(queues = TopicConstant.QUEUE_NAME_1)
    @RabbitHandler
    public void onMessage1(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, TopicConstant.QUEUE_NAME_1, "onMessage1");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = TopicConstant.QUEUE_NAME_2)
    @RabbitHandler
    public void onMessage2(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, TopicConstant.QUEUE_NAME_2, "onMessage2");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = TopicConstant.QUEUE_NAME_3)
    @RabbitHandler
    public void onMessage3(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, TopicConstant.QUEUE_NAME_3, "onMessage3");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
