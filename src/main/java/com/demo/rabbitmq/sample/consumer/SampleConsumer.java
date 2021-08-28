package com.demo.rabbitmq.sample.consumer;

import com.demo.rabbitmq.sample.constant.SampleConstant;
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
public class SampleConsumer {

    @RabbitListener(queues = SampleConstant.QUEUE_NAME)
    @RabbitHandler
    public void onMessage(@Payload String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        try {
            log.info("Receive message={}, Queue={}, Method={}", message, SampleConstant.QUEUE_NAME, "onMessage");
            channel.basicAck(deliveryTag, Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
