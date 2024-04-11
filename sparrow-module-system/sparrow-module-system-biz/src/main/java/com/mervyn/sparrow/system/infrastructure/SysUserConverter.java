package com.mervyn.sparrow.system.infrastructure;

import com.mervyn.sparrow.system.entity.SysUserDTO;
import com.mervyn.sparrow.system.model.SysUser;
import com.mervyn.sparrow.system.view.SysUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * $
 *
 * @author 9ao2hen
 * @date 2024/3/6 16:39
 */
@Mapper
public interface SysUserConverter {

    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

    SysUserDTO po2Dto(SysUser po);

    List<SysUserDTO> po2Dto(List<SysUser> list);

    SysUser dto2Po(SysUserDTO dto);

    List<SysUser> dto2Po(List<SysUserDTO> dto);

    SysUserVo dto2Vo(SysUserDTO dto);

    List<SysUserVo> dto2Vo(List<SysUserDTO> dto);

}
