package com.mervyn.sparrow.system.manager.impl;

import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.manager.SysMenuManager;
import com.mervyn.sparrow.system.mapper.SysMenuMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * $
 *
 * @author 9ao2hen
 * @date 2024/3/6 15:53
 */
@Service
public class SysMenuManagerImpl implements SysMenuManager {

    @Resource
    SysMenuMapper mapper;

    @Override
    public Long add(SysMenuDTO menuDTO){

        return null;
    }

}
