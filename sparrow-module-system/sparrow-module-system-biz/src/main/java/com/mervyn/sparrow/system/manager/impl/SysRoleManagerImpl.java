package com.mervyn.sparrow.system.manager.impl;

import cn.hutool.core.lang.Assert;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.common.utils.IdGenerator;
import com.mervyn.sparrow.config.lang.AssertSpr;
import com.mervyn.sparrow.system.entity.SysRoleDTO;
import com.mervyn.sparrow.system.infrastructure.SysRoleConverter;
import com.mervyn.sparrow.system.manager.SysRoleManager;
import com.mervyn.sparrow.system.mapper.SysMenuMapper;
import com.mervyn.sparrow.system.mapper.SysRoleMapper;
import com.mervyn.sparrow.system.mapper.SysRoleMenuMapper;
import com.mervyn.sparrow.system.model.SysRole;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/4/19 14:32
 */
@Service
public class SysRoleManagerImpl implements SysRoleManager {


    @Resource
    SysRoleMapper mapper;
    @Resource
    SysMenuMapper menuMapper;
    @Resource
    SysRoleMenuMapper roleMenuMapper;


    @Override
    public int deleteById(Long id) {
       return mapper.deleteById(id);
    }

    @Override
    public int insert(SysRole role) {
        Assert.notNull(role,"SysRole不能为空");
        if (role.getId() == null){
            role.setId(IdGenerator.genId());
        }
        role.setDeleted(SystemEnum.Deleted.UNDELETED.getCode());
        role.setStatus(SystemEnum.CommonStatus.enable.getCode());
        return mapper.insert(role);
    }

    @Override
    public int insertSelective(SysRole role) {
        Assert.notNull(role,"SysRole不能为空");
        if (role.getId() == null){
            role.setId(IdGenerator.genId());
        }
        return mapper.insertSelective(role);
    }

    @Override
    public SysRoleDTO selectById(Long id) {
        SysRole sysRole = mapper.selectById(id);
        return SysRoleConverter.INSTANCE.po2Dto(sysRole);
    }

    @Override
    public int updateByIdSelective(SysRole role) {
        return mapper.updateByIdSelective(role);
    }

    @Override
    public int updateById(SysRole role) {
        AssertSpr.notNull(role,"SysRole不能为空");
        AssertSpr.notNull(role.getId(),"id 不能为空");
        return mapper.updateById(role);
    }

    @Override
    public List<SysRoleDTO> getRoleList(SysRole role){
        List<SysRole> roleList = mapper.getList(role);
        return SysRoleConverter.INSTANCE.po2Dto(roleList);
    }







}
