package com.demo.rabbitmq.direct.config;

import com.demo.rabbitmq.direct.constant.DirectConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class DirectModeConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          Queue queue1 = new Queue(DirectConstant.QUEUE_NAME_1);
          Queue queue2 = new Queue(DirectConstant.QUEUE_NAME_2);
          DirectExchange exchange = new DirectExchange(DirectConstant.EXCHANGE_NAME,true,false);
          this.amqpAdmin.declareQueue(queue1);
          this.amqpAdmin.declareQueue(queue2);
          this.amqpAdmin.declareExchange(exchange);
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue1).to(exchange).with(DirectConstant.ROUTING_KEY_1));
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue2).to(exchange).with(DirectConstant.ROUTING_KEY_2));
     }

}
