package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.common.data.domain.Pages;
import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.infrastructure.SysUserConverter;
import com.mervyn.sparrow.system.param.SysUserAddReq;
import com.mervyn.sparrow.system.param.SysUserQuery;
import com.mervyn.sparrow.system.service.SysUserService;
import com.mervyn.sparrow.system.view.SysUserVo;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 2hen9ao
 * @date 2024/4/10 18:49
 */
@Validated
@RestController
@RequestMapping("/system/user")
public class SystemUserController {

    @Resource
    SysUserService sysUserService;

    @GetMapping("/info")
    public Result<SysUserVo> infoById(@RequestParam("userId") String userId) {
        SysUserDTO userById = sysUserService.getUserById(userId);
        SysUserVo sysUserVo = SysUserConverter.INSTANCE.dto2Vo(userById);
        return Results.success(sysUserVo);
    }

    @GetMapping("/info/{username}")
    public Result<SysUserVo> infoByUserName(@PathVariable String username) {
        SysUserDTO userByName = sysUserService.getUserByUserName(username);
        SysUserVo sysUserVo = SysUserConverter.INSTANCE.dto2Vo(userByName);
        return Results.success(sysUserVo);
    }

    @GetMapping("/profile")
    public Result<SysUserVo> profile() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        SysUserDTO userById = sysUserService.getUserByUserName(details.getUsername());
        SysUserVo sysUserVo = SysUserConverter.INSTANCE.dto2Vo(userById);
        return Results.success(sysUserVo);
    }

    @PostMapping("/create")
    public Result<Map<String, String>> create(@RequestBody @Valid SysUserAddReq req) {
        String userId = sysUserService.createUser(req);
        return Results.success(Collections.singletonMap("userId", userId));
    }

    @GetMapping("/page")
    public Result<PageResult<SysUserVo>> list(@RequestBody SysUserQuery query) {
        PageResult<SysUserDTO> page = sysUserService.getPage(query);
        List<SysUserVo> voList = SysUserConverter.INSTANCE.dto2Vo(page.getList());
        return Results.success(Pages.of(voList,page.getPageSize(), page.getPageNum(), page.getTotal()));
    }



}
