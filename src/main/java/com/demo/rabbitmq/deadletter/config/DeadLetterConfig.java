package com.demo.rabbitmq.deadletter.config;

import com.demo.rabbitmq.deadletter.constant.DeadLetterConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class DeadLetterConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          Queue queue1 = new Queue(DeadLetterConstant.QUEUE_NAME_FROM, true, false, false, this.getArguments());
          Queue queue2 = new Queue(DeadLetterConstant.QUEUE_NAME_TO);
          DirectExchange exchange1 = new DirectExchange(DeadLetterConstant.EXCHANGE_NAME_FROM,true,false);
          DirectExchange exchange2 = new DirectExchange(DeadLetterConstant.EXCHANGE_NAME_TO,true,false);
          this.amqpAdmin.declareQueue(queue1);
          this.amqpAdmin.declareQueue(queue2);
          this.amqpAdmin.declareExchange(exchange1);
          this.amqpAdmin.declareExchange(exchange2);
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue1).to(exchange1).with(DeadLetterConstant.ROUTING_KEY_FROM));
          this.amqpAdmin.declareBinding(BindingBuilder.bind(queue2).to(exchange2).with(DeadLetterConstant.ROUTING_KEY_TO));
     }

     public Map<String, Object> getArguments(){
          Map<String, Object> arguments = new HashMap<>(2);
          arguments.put("x-dead-letter-exchange", DeadLetterConstant.EXCHANGE_NAME_TO);
          arguments.put("x-dead-letter-routing-key", DeadLetterConstant.ROUTING_KEY_TO);
          return arguments;
     }

}
