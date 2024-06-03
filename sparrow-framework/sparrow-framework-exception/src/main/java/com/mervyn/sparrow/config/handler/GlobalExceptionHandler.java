package com.mervyn.sparrow.config.handler;

import cn.hutool.core.text.StrFormatter;
import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.config.expection.SparrowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author 2hen9ao
 * @date 2024/3/7 12:45
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //日志
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result<Void> error(Exception e){
        log.error("exception message", e);
        return Results.error(e.getMessage());
    }

    @ExceptionHandler(SparrowException.class)
    public Result<Void> error(SparrowException e){
        log.error("exception message", e);
        return Results.error(e.getMessage());
    }

    //参数异常，MissingServletRequestParameterException
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Void> error(MissingServletRequestParameterException e){
        String format = StrFormatter.format("缺少参数:{}", e.getParameterName());
        log.error(format);
        return Results.error(format);
    }

}
