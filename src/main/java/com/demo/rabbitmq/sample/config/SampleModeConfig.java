package com.demo.rabbitmq.sample.config;

import com.demo.rabbitmq.sample.constant.SampleConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author mao2080@sina.com
 */
@Configuration
public class SampleModeConfig {

     @Autowired
     private AmqpAdmin amqpAdmin;

     @PostConstruct
     public void declareQueue(){
          this.amqpAdmin.declareQueue(new Queue(SampleConstant.QUEUE_NAME));
     }

}
