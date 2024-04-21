package com.mervyn.sparrow.system.infrastructure;

import com.mervyn.sparrow.system.entity.SysRoleDTO;
import com.mervyn.sparrow.system.model.SysRole;
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
public interface SysRoleConverter {

    SysRoleConverter INSTANCE = Mappers.getMapper(SysRoleConverter.class);

    SysRoleDTO po2Dto(SysRole menu);

    List<SysRoleDTO> po2Dto(List<SysRole> menu);

    SysRole dto2Po(SysRoleDTO dto);

    List<SysRole> dto2Po(List<SysRoleDTO> dto);


}
