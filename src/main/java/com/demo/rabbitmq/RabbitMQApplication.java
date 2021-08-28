package com.demo.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mao2080@sina.com
 */
@SpringBootApplication(scanBasePackages = "com.demo")
public class RabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
        System.out.println("http://localhost:8080/rabbitMQController/sample");
        System.out.println("http://localhost:8080/rabbitMQController/work");
        System.out.println("http://localhost:8080/rabbitMQController/direct");
        System.out.println("http://localhost:8080/rabbitMQController/fanout");
        System.out.println("http://localhost:8080/rabbitMQController/topic");
        System.out.println("https://www.cnblogs.com/linyufeng/p/9885645.html");
        System.out.println("https://www.cnblogs.com/liuyingke/p/13294517.html");
    }

}
