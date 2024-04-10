package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.query.SysUserLogin;
import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2hen9ao
 * @date 2024/4/10 18:49
 */
@RestController
@RequestMapping("/system/user")
public class SystemUserController {

    @Resource
    SysUserService sysUserService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody SysUserLogin sysUserLogin) {

        // 登录逻辑
        String token = sysUserService.login(sysUserLogin.getUsername(), sysUserLogin.getPassword());
        return Results.success(token);
    }
}
