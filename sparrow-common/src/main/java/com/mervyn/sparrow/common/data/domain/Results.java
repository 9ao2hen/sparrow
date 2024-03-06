package com.mervyn.sparrow.common.data.domain;

import com.mervyn.sparrow.common.enums.ResponseEnum;

/**
 * @author 2hen9ao
 * @date 2024/3/5 13:53
 */
public final class Results {

    public Results() {
    }

    public static Result<Void> success(){
        return new DefaultResult(ResponseEnum.ResultCode.success.getCode(),
                ResponseEnum.ResultCode.success.getMsg(),
                null);
    }

    public static <T> Result<T> success(T data){
        return new DefaultResult(ResponseEnum.ResultCode.success.getCode(),
                ResponseEnum.ResultCode.success.getMsg(),
                data);
    }


}
