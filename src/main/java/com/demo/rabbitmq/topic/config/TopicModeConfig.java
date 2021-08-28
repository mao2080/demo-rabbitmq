package com.demo.rabbitmq.topic.config;

import com.demo.rabbitmq.topic.constant.TopicConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class TopicModeConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          Queue queue1 = new Queue(TopicConstant.QUEUE_NAME_1);
          Queue queue2 = new Queue(TopicConstant.QUEUE_NAME_2);
          Queue queue3 = new Queue(TopicConstant.QUEUE_NAME_3);
          TopicExchange exchange = new TopicExchange(TopicConstant.EXCHANGE_NAME,true,false);
          this.amqpAdmin.declareQueue(queue1);
          this.amqpAdmin.declareQueue(queue2);
          this.amqpAdmin.declareQueue(queue3);
          this.amqpAdmin.declareExchange(exchange);
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue1).to(exchange).with("topic.operate.delete.user"));
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue2).to(exchange).with("topic.operate.delete.*"));
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue3).to(exchange).with("topic.operate.#"));
     }

}
