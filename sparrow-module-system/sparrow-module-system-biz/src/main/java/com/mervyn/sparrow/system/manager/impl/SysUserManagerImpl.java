package com.mervyn.sparrow.system.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mervyn.sparrow.common.data.domain.PageResult;
import com.mervyn.sparrow.common.data.domain.Pages;
import com.mervyn.sparrow.common.enums.SystemEnum;
import com.mervyn.sparrow.common.utils.IdGenerator;
import com.mervyn.sparrow.config.lang.AssertSpr;
import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.infrastructure.SysUserConverter;
import com.mervyn.sparrow.system.manager.SysUserManager;
import com.mervyn.sparrow.system.mapper.SysUserMapper;
import com.mervyn.sparrow.system.model.SysUser;
import com.mervyn.sparrow.system.param.SysUserQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 2hen9ao
 * @date 2024/3/11 14:28
 */

@Service
public class SysUserManagerImpl implements SysUserManager {

    @Resource
    SysUserMapper mapper;

    @Override
    public Long createUser(SysUserDTO userDTO) {
        SysUserDTO byUserName = getUserByUserName(userDTO.getUsername());
        AssertSpr.isTrue(byUserName == null, "用户名{}已存在",userDTO.getUsername());
        SysUser sysUser = SysUserConverter.INSTANCE.dto2Po(userDTO);
        sysUser.setId(IdGenerator.genId());
        Date now = new Date();
        sysUser.setCreateTime(now);
        sysUser.setUpdateTime(now);
        sysUser.setStatus(SystemEnum.CommonStatus.enable.getCode());
        sysUser.setDeleted(SystemEnum.Deleted.UNDELETED.getCode());
        int row = mapper.insertSelective(sysUser);
        return row > 0 ? sysUser.getId() : null;
    }

    @Override
    public SysUserDTO updateUser(SysUserDTO userDTO) {
        SysUser sysUser = SysUserConverter.INSTANCE.dto2Po(userDTO);
        int row = mapper.updateByPrimaryKeySelective(sysUser);
        return row > 0 ? userDTO : null;
    }

    @Override
    public Integer updateStatus(Long userId, SystemEnum.CommonStatus status) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setStatus(status.getCode());
        sysUser.setUpdateTime(new Date());
        int row = mapper.updateByPrimaryKeySelective(sysUser);
        return row > 0 ? row : null;
    }

    @Override
    public Integer deleteUser(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setDeleted(SystemEnum.Deleted.DELETED.getCode());
        sysUser.setUpdateTime(new Date());
        int row = mapper.updateByPrimaryKeySelective(sysUser);
        return row;
    }

    @Override
    public SysUserDTO getUserById(Long userId) {
        SysUser sysUser = mapper.selectByPrimaryKey(userId);
        return SysUserConverter.INSTANCE.po2Dto(sysUser);
    }

    @Override
    public SysUserDTO getUserByUserName(String username) {
        SysUser sysUser = mapper.selectByUsername(username);
        return SysUserConverter.INSTANCE.po2Dto(sysUser);
    }

    @Override
    public List<SysUserDTO> getList(SysUserDTO userDTO) {
        SysUser sysUser = SysUserConverter.INSTANCE.dto2Po(userDTO);
        List<SysUser> userList = mapper.selectList(sysUser);
        return SysUserConverter.INSTANCE.po2Dto(userList);
    }

    @Override
    public PageResult<SysUserDTO> getPage( SysUserQuery query) {
        PageHelper.startPage(query.getPageNumber(),query.getPageSize());
        List<SysUser> userList = mapper.selectPage(query);
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        List<SysUserDTO> list = SysUserConverter.INSTANCE.po2Dto(userList);
        return Pages.of(list, pageInfo.getPageSize(), pageInfo.getPageNum(), pageInfo.getTotal());
    }



}
