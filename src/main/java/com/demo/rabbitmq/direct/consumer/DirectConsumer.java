package com.demo.rabbitmq.direct.consumer;

import com.demo.rabbitmq.direct.constant.DirectConstant;
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
public class DirectConsumer {

    @RabbitListener(queues = DirectConstant.QUEUE_NAME_1)
    @RabbitHandler
    public void onMessage1(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, DirectConstant.QUEUE_NAME_1, "onMessage1");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = DirectConstant.QUEUE_NAME_2)
    @RabbitHandler
    public void onMessage2(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, DirectConstant.QUEUE_NAME_2, "onMessage2");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
