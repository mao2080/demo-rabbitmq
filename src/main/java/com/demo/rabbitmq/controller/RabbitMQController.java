package com.demo.rabbitmq.controller;

import com.demo.rabbitmq.beans.ResObj;
import com.demo.rabbitmq.beans.DemoMessage;
import com.demo.rabbitmq.deadletter.constant.DeadLetterConstant;
import com.demo.rabbitmq.deadletter.producer.DeadLetterProducer;
import com.demo.rabbitmq.direct.constant.DirectConstant;
import com.demo.rabbitmq.direct.producer.DirectProducer;
import com.demo.rabbitmq.fanout.constant.FanoutConstant;
import com.demo.rabbitmq.fanout.producer.FanoutProducer;
import com.demo.rabbitmq.sample.constant.SampleConstant;
import com.demo.rabbitmq.sample.producer.SampleProducer;
import com.demo.rabbitmq.topic.constant.TopicConstant;
import com.demo.rabbitmq.topic.producer.TopicProducer;
import com.demo.rabbitmq.work.constant.WorkConstant;
import com.demo.rabbitmq.work.producer.WorkProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mao2080@sina.com
 */
@Slf4j
@RestController
@RequestMapping("/rabbitMQController")
public class RabbitMQController {

    private final static String DEFAULT_EXCHANGE_NAME = "AMQP default";

    @Autowired
    private SampleProducer sampleProducer;

    @Autowired
    private WorkProducer workProducer;

    @Autowired
    private DirectProducer directProducer;

    @Autowired
    private FanoutProducer fanoutProducer;

    @Autowired
    private TopicProducer topicProducer;

    @Autowired
    private DeadLetterProducer deadLetterProducer;

    /**
     * 描述：简单模式
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/sample")
    @ResponseBody
    public ResObj sample() {
        try {
            this.sampleProducer.sendMessage(new DemoMessage(SampleConstant.MODE, DEFAULT_EXCHANGE_NAME));
            this.sampleProducer.sendMessage(new DemoMessage(SampleConstant.MODE, DEFAULT_EXCHANGE_NAME));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }

    /**
     * 描述：工作模式
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/work")
    @ResponseBody
    public ResObj work() {
        try {
            this.workProducer.sendMessage(new DemoMessage(WorkConstant.MODE, DEFAULT_EXCHANGE_NAME));
            this.workProducer.sendMessage(new DemoMessage(WorkConstant.MODE, DEFAULT_EXCHANGE_NAME));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }

    /**
     * 描述：直接模式
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/direct")
    @ResponseBody
    public ResObj sampleProducer() {
        try {
            this.directProducer.sendMessage(new DemoMessage(DirectConstant.MODE, DirectConstant.ROUTING_KEY_1, DirectConstant.EXCHANGE_NAME));
            this.directProducer.sendMessage(new DemoMessage(DirectConstant.MODE, DirectConstant.ROUTING_KEY_2, DirectConstant.EXCHANGE_NAME));
            this.directProducer.sendMessage(new DemoMessage(DirectConstant.MODE, DirectConstant.ROUTING_KEY_1, DirectConstant.EXCHANGE_NAME));
            this.directProducer.sendMessage(new DemoMessage(DirectConstant.MODE, DirectConstant.ROUTING_KEY_2, DirectConstant.EXCHANGE_NAME));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }

    /**
     * 描述：广播模式
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/fanout")
    @ResponseBody
    public ResObj fanout() {
        try {
            this.fanoutProducer.sendMessage(new DemoMessage(FanoutConstant.MODE, FanoutConstant.EXCHANGE_NAME));
            this.fanoutProducer.sendMessage(new DemoMessage(FanoutConstant.MODE, FanoutConstant.EXCHANGE_NAME));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }

    /**
     * 描述：主题模式
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/topic")
    @ResponseBody
    public ResObj topic() {
        try {
            this.topicProducer.sendMessage(new DemoMessage(TopicConstant.MODE, TopicConstant.ROUTING_KEY_1, TopicConstant.EXCHANGE_NAME));
            this.topicProducer.sendMessage(new DemoMessage(TopicConstant.MODE, TopicConstant.ROUTING_KEY_2, TopicConstant.EXCHANGE_NAME));
            this.topicProducer.sendMessage(new DemoMessage(TopicConstant.MODE, TopicConstant.ROUTING_KEY_3, TopicConstant.EXCHANGE_NAME));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }



    /**
     * 描述：死信队列
     * @author mao2080@sina.com
     * @created 2018/9/1 20:17
     * @return ResObj
     */
    @RequestMapping(value = "/dead-letter")
    @ResponseBody
    public ResObj deadLetter() {
        try {
            this.deadLetterProducer.sendMessage(new DemoMessage(DeadLetterConstant.MODE));
            return new ResObj();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResObj(e);
        }
    }


}