package com.mervyn.sparrow.common.data.domain;

import java.io.Serializable;

/**
 * @author 2hen9ao
 * @date 2024/3/5 13:46
 */
public class DefaultResult<T> implements Result<T>, Serializable {

    private static final long serialVersionUID = -3965949747382602087L;

    private String code;
    private String message;
    private T data;

    public DefaultResult() {
    }

    public DefaultResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public DefaultResult<T> setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public DefaultResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public DefaultResult<T> setData(T data) {
        this.data = data;
        return null;
    }

    @Override
    public String toString() {
        return "DefaultResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
