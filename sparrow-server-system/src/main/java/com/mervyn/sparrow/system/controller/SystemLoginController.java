package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.param.SysUserLogin;
import com.mervyn.sparrow.system.service.SysUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2hen9ao
 * @date 2024/4/10 18:49
 */
@RestController
@RequestMapping("/system")
@Slf4j
public class SystemLoginController {

    @Resource
    SysUserService sysUserService;


    @PostMapping("/login")
    public Result<String> login(@RequestBody SysUserLogin sysUserLogin) {
        // 登录逻辑
        String token = sysUserService.login(sysUserLogin.getUsername(), sysUserLogin.getPassword());
        log.info("用户登陆:{}",sysUserLogin.getUsername());
        return Results.success(token);
    }

//    @PostMapping("/signup")
//    public Result<String> signup(@RequestBody SysUserDTO userDTO) {
//        String user = sysUserService.createUser(userDTO);
//        return Results.success(user);
//    }

    @PostMapping("/logout")
    public Result<String> logout() {
        String token = sysUserService.logout();
        return Results.success("token");
    }




}
