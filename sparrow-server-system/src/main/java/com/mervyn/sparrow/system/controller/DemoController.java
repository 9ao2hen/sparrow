package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.config.lang.AssertSpr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2hen9ao
 * @date 2024/3/5 11:28
 */
@RestController
@RequestMapping("/test")
public class DemoController {



    @GetMapping("")
    public Result<String> test(){
        Result<String> success = Results.success("success");
        return success;
    }


    @GetMapping("/error")
    public Result error() throws Exception {
        throw new Exception("错了错了");
    }

    @GetMapping("/ass")
    public Result<String> as(){
        AssertSpr.isTrue(1==2,"必须是true,param = {}","notnull");
        return Results.success("ass");
    }


}
