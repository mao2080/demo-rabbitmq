package com.demo.rabbitmq.beans;

import com.demo.rabbitmq.util.CommonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author mao2080@sina.com
 */
@Setter
@Getter
public class DemoMessage implements Serializable {

    private String mode;

    private String routingKey;

    private String exchangeName;

    private String createTime;

    public DemoMessage(String mode, String exchangeName) {
        this.mode = mode;
        this.exchangeName = exchangeName;
        this.createTime = CommonUtil.getNowTime();
    }

    public DemoMessage(String mode, String routingKey, String exchangeName) {
        this.mode = mode;
        this.routingKey = routingKey;
        this.exchangeName = exchangeName;
        this.createTime = CommonUtil.getNowTime();
    }

    @Override
    public String toString() {
        return "DemoMessage{" +
                "mode='" + mode + '\'' +
                ", routingKey='" + routingKey + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

}
