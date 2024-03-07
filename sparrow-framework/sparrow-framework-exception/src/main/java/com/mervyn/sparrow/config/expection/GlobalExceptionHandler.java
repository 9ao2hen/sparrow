package com.mervyn.sparrow.config.expection;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author 2hen9ao
 * @date 2024/3/7 12:45
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Result<Void> error(Exception e){
        e.printStackTrace();
        return Results.error(e.getMessage());
    }

}
