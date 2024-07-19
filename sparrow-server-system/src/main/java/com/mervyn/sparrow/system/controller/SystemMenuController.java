package com.mervyn.sparrow.system.controller;

import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.common.data.domain.Pages;
import com.mervyn.sparrow.common.data.domain.Result;
import com.mervyn.sparrow.common.data.domain.Results;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.infrastructure.SysMenuConverter;
import com.mervyn.sparrow.system.param.MenuQuery;
import com.mervyn.sparrow.system.param.SysMenuAddReq;
import com.mervyn.sparrow.system.param.SysMenuEditReq;
import com.mervyn.sparrow.system.service.SysMenuService;
import com.mervyn.sparrow.system.view.SysMenuVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 2hen9ao
 * @date 2024/3/8 18:39
 */
@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {

    @Resource
    SysMenuService menuService;


    @GetMapping("/routers")
    public Result<SysMenuDTO> getRouters() {
        //TODO
//        menuService.
        return Results.success(null);
    }

    @GetMapping("/info")
    public Result<SysMenuVo> getById(@RequestParam(name = "id") Long id) {
        SysMenuDTO menuDTO = menuService.getById(id);
        return Results.success(SysMenuConverter.INSTANCE.dto2Vo(menuDTO));
    }

    @PostMapping("/create")
    public Result<Map<String, String>> addMenu(@RequestBody SysMenuAddReq req) {
        String menuId = menuService.createMenu(SysMenuConverter.INSTANCE.addReq2Dto(req));
        return Results.success(Collections.singletonMap("id", menuId));
    }

    @PostMapping("/update")
    public Result<SysMenuDTO> updateMenu(@RequestBody SysMenuEditReq req) {
        SysMenuDTO modifyMenu = menuService.modifyMenu(req);
        return Results.success(modifyMenu);
    }

    @PostMapping("/delete")
    public Result<String> deleteMenu(@RequestParam(name = "id") String id) {
        String row = menuService.deleteMenu(id);
        return Results.success(row);
    }

    @GetMapping("/list")
    public Result<List<SysMenuVo>> listMenu() {
        List<SysMenuDTO> allMenu = menuService.getAllMenu();
        return Results.success(SysMenuConverter.INSTANCE.dto2Vo(allMenu));
    }

    @GetMapping("/page")
    public Result<PageResult<SysMenuVo>> page(@RequestBody MenuQuery query) {
        PageResult<SysMenuDTO> page = menuService.getPage(query);
        PageResult<SysMenuVo> pageResult = Pages.of(SysMenuConverter.INSTANCE.dto2Vo(page.getList()), page.getPageSize(), page.getPageNum(), page.getTotal());
        return Results.success(pageResult);
    }

}
