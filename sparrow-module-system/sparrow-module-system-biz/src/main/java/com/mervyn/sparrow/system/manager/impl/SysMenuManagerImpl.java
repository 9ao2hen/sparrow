package com.mervyn.sparrow.system.manager.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.common.data.domain.Pages;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.config.lang.AssertSpr;
import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.infrastructure.SysMenuConverter;
import com.mervyn.sparrow.system.manager.SysMenuManager;
import com.mervyn.sparrow.system.mapper.SysMenuMapper;
import com.mervyn.sparrow.system.model.SysMenu;
import com.mervyn.sparrow.system.param.MenuQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 9ao2hen
 * @date 2024/3/6 15:53
 */
@Service
public class SysMenuManagerImpl implements SysMenuManager {

    @Resource
    SysMenuMapper mapper;

    @Override
    public Long add(SysMenuDTO menuDTO) {
//        SysMenu byPath = getByPath(menuDTO.getPath());
        //path 唯一性验证
//        AssertSpr.isNull(byPath,"{}已存在",menuDTO.getPath());
        SysMenu sysMenu = SysMenuConverter.INSTANCE.dto2Po(menuDTO);
        sysMenu.setId(sysMenu.getId());
        sysMenu.setDeleted(SystemEnum.Deleted.UNDELETED.getCode());
        sysMenu.setStatus(SystemEnum.CommonStatus.enable.getCode());
        int row = mapper.insertSelective(sysMenu);
        return row > 0 ? sysMenu.getId() : null;
    }

    @Override
    public Long update(SysMenuDTO menuDTO) {
        //id 不能为空
        AssertSpr.notNull(menuDTO.getId(),"id 不能为空");
        SysMenu byPath = getByPath(menuDTO.getPath());
        if (Objects.nonNull(byPath)){
            AssertSpr.isTrue(StrUtil.equals(String.valueOf(byPath.getId()),menuDTO.getId()),"path 已经存在");
        }

        SysMenu sysMenu = SysMenuConverter.INSTANCE.dto2Po(menuDTO);
        int row = mapper.updateByPrimaryKeySelective(sysMenu);
        return row > 0 ? sysMenu.getId() : null;
    }

    @Override
    public Long delete(Long id){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(id);
        sysMenu.setDeleted(SystemEnum.Deleted.DELETED.getCode());
        int row = mapper.updateByPrimaryKeySelective(sysMenu);
        return row > 0 ? sysMenu.getId() : null;
    }

    @Override
    public SysMenu getById(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public SysMenu getByPath(String path){
        return mapper.getByCode(path);
    }


    @Override
    public List<SysMenu> selectMenu(SysMenu menu){
        return mapper.selectList(menu);
    }

    @Override
    public List<SysMenu> getMenuByRole(String roleId){
        //todo 根据角色获取菜单
        return null;
    }

    @Override
    public PageResult<SysMenuDTO> getPage(MenuQuery query) {
        PageHelper.startPage(query.getPageNumber(),query.getPageSize());
        List<SysMenu> userList = mapper.selectPage(query);
        PageInfo<SysMenu> pageInfo = new PageInfo<>(userList);
        List<SysMenuDTO> list = SysMenuConverter.INSTANCE.po2Dto(userList);
        return Pages.of(list, pageInfo.getPageSize(), pageInfo.getPageNum(), pageInfo.getTotal());
    }



}
