package com.nona.user.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class ResponseFactory<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态
     */
    private String statusCode;

    /**
     * 自定义信息,提示语句
     */
    private String message;

    /**
     * 耗时，毫秒
     */
    private long cost;

    /**
     * 返回值
     */
    private T data;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseFactory(String statusCode, String message, T data, long cost) {
        super();
        this.statusCode = statusCode;
        this.data = data;
        this.cost = cost;
        this.message = message;
    }

    /**
     * 成功的结果
     *
     * @param data 返回结果
     */
    public static ResponseFactory responseSuccess(Object data) {
        return new ResponseFactory(String.valueOf(HttpStatus.OK.value()), "操作成功", data, 0);
    }

    /**
     * 成功的结果
     *
     * @param data 数据集
     * @param cost 耗时
     * @return 返回结果
     */
    public static ResponseFactory responseSuccess(Object data, long cost) {
        return new ResponseFactory(String.valueOf(HttpStatus.OK.value()), "操作成功", data, cost);
    }


    /**
     * 失败的结果
     *
     * @param message 错误信息
     */
    public static ResponseFactory responseFail(String message) {
        return new ResponseFactory(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), message, new HashMap<>(), 0);
    }


    /**
     * 失败的结果
     *
     * @param message 错误信息
     * @param cost    耗时
     * @return
     */
    public static ResponseFactory responseFail(String message, long cost) {
        return new ResponseFactory(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), message, new HashMap<>(), cost);
    }

    /**
     * 失败的结果
     *
     * @param statusCode 错误编码，用于自定义错误信息
     * @param message    错误信息
     * @return
     */
    public static ResponseFactory responseFail(String statusCode, String message) {
        return new ResponseFactory(statusCode, message, new HashMap<>(), 0);
    }

    public ResponseFactory() {
    }
}
