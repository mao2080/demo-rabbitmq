package com.demo.rabbitmq.work.config;

import com.demo.rabbitmq.work.constant.WorkConstant;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class WorkModeConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          this.amqpAdmin.declareQueue(new Queue(WorkConstant.QUEUE_NAME));
     }

}
