package com.mervyn.sparrow.system.infrastructure;

import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.model.SysMenu;
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
public interface SysMenuConverter {

    SysMenuConverter INSTANCE = Mappers.getMapper( SysMenuConverter.class );

    SysMenuDTO po2Dto(SysMenu menu);

    List<SysMenuDTO> po2Dto(List<SysMenu> menu);

    SysMenu dto2Po(SysMenuDTO dto);
    List<SysMenu> dto2Po(List<SysMenuDTO> dto);


}
