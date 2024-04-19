package com.mervyn.sparrow.system.manager.impl;

import cn.hutool.core.lang.Assert;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.common.utils.IdGenerator;
import com.mervyn.sparrow.config.lang.AssertSpr;
import com.mervyn.sparrow.system.manager.SysRoleManager;
import com.mervyn.sparrow.system.mapper.SysRoleMapper;
import com.mervyn.sparrow.system.model.SysRole;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 2hen9ao
 * @date 2024/4/19 14:32
 */
@Service
public class SysRoleManagerImpl implements SysRoleManager {


    @Resource
    SysRoleMapper mapper;


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
    public SysRole selectById(Long id) {
        return mapper.selectById(id);
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




}
