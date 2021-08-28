package com.demo.rabbitmq.fanout.consumer;

import com.demo.rabbitmq.fanout.constant.FanoutConstant;
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
public class FanoutConsumer {

    @RabbitListener(queues = FanoutConstant.QUEUE_NAME_1)
    @RabbitHandler
    public void onMessage1(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, FanoutConstant.QUEUE_NAME_1, "onMessage1");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = FanoutConstant.QUEUE_NAME_2)
    @RabbitHandler
    public void onMessage2(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, FanoutConstant.QUEUE_NAME_2, "onMessage2");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
