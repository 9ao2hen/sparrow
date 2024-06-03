package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.infrastructure.SysUserConverter;
import com.mervyn.sparrow.system.service.SysUserService;
import com.mervyn.sparrow.system.view.SysUserVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/detail")
    public Result<SysUserVo> detail(@RequestParam("userId") String userId) {

        SysUserDTO userById = sysUserService.getUserById(userId);
        SysUserVo sysUserVo = SysUserConverter.INSTANCE.dto2Vo(userById);
        return Results.success(sysUserVo);
    }

}
