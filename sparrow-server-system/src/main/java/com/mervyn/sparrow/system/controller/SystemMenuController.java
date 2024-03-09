package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.service.SysMenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 2hen9ao
 * @date 2024/3/8 18:39
 */
@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {

    @Resource
    SysMenuService menuService;

    @GetMapping("/info")
    public Result<SysMenuDTO> getById(@RequestParam(name = "id") Long id){
        SysMenuDTO menuDTO = menuService.getById(id);
        return Results.success(menuDTO);
    }

    @PostMapping("/add")
    public Result<String> addMenu(@RequestBody SysMenuDTO menuDTO){
        String menuId = menuService.createMenu(menuDTO);
        return Results.success(menuId);
    }

    @PostMapping("/update")
    public Result<SysMenuDTO> updateMenu(@RequestBody SysMenuDTO menuDTO){
        SysMenuDTO modifyMenu = menuService.modifyMenu(menuDTO);
        return Results.success(modifyMenu);
    }

}
