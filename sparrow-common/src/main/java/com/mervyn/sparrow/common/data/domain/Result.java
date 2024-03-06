package com.mervyn.sparrow.common.data.domain;

import java.io.Serializable;

/**
 * @author 2hen9ao
 * @date 2024/3/5 13:35
 */
public interface Result<T> extends Serializable {

    String getCode();
    String getMessage();
    T getData();

    Result<T> setCode(String code);
    Result<T> setMessage(String message);
    Result<T> setData(T data);

}
