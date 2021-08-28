package com.demo.rabbitmq.fanout.config;

import com.demo.rabbitmq.fanout.constant.FanoutConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class FanoutModeConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          Queue queue1 = new Queue(FanoutConstant.QUEUE_NAME_1);
          Queue queue2 = new Queue(FanoutConstant.QUEUE_NAME_2);
          FanoutExchange exchange = new FanoutExchange(FanoutConstant.EXCHANGE_NAME,true,false);
          this.amqpAdmin.declareQueue(queue1);
          this.amqpAdmin.declareQueue(queue2);
          this.amqpAdmin.declareExchange(exchange);
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue1).to(exchange));
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue2).to(exchange));
     }

}
