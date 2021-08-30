package com.demo.rabbitmq.deadletter.constant;

/**
 * @author mao2080@sina.com
 */
public class DeadLetterConstant {

    public final static String MODE = "dead-letter";

    public final static String EXCHANGE_NAME_FROM = "dead-letter-exchange-from";

    public final static String EXCHANGE_NAME_TO = "dead-letter-exchange-to";

    public final static String QUEUE_NAME_FROM = "dead-letter-queue-from";

    public final static String QUEUE_NAME_TO = "dead-letter-queue-to";

    public final static String ROUTING_KEY_FROM = "dead-letter-routing-key-from";

    public final static String ROUTING_KEY_TO = "dead-letter-routing-key-to";

    public final static String EXPIRATION_TIME = "60000";

}
