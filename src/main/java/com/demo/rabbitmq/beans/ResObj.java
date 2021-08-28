package com.demo.rabbitmq.beans;


import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

/**
 * @author mao2080@sina.com
 */
@Setter
@Getter
public class ResObj {

    /**状态代码*/
    private int code = HttpStatus.SC_OK;

    /**状态描述*/
    private String desc = "Success";

    /**返回数据*/
    private Object data;

    public ResObj() {

    }

    public ResObj(Object data) {
        this.data = data;
    }

    public ResObj(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
