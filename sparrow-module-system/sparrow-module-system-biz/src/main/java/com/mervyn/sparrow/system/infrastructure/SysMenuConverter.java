package com.mervyn.sparrow.system.infrastructure;

import com.mervyn.sparrow.system.entity.SysMenuDTO;
import com.mervyn.sparrow.system.model.SysMenu;
import com.mervyn.sparrow.system.param.MenuQuery;
import com.mervyn.sparrow.system.param.SysMenuAddReq;
import com.mervyn.sparrow.system.param.SysMenuEditReq;
import com.mervyn.sparrow.system.view.SysMenuVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * $
 *
 * @author 9ao2hen
 * @date 2024/3/6 16:39
 */
@Mapper(uses = EnumConverter.class)
public interface SysMenuConverter {

    SysMenuConverter INSTANCE = Mappers.getMapper(SysMenuConverter.class);

    SysMenuDTO po2Dto(SysMenu menu);
    List<SysMenuDTO> po2Dto(List<SysMenu> menu);

    SysMenu dto2Po(SysMenuDTO dto);
    List<SysMenu> dto2Po(List<SysMenuDTO> dto);

    SysMenuDTO vo2Dto(MenuQuery menu);
    List<SysMenuDTO> vo2Dto(List<MenuQuery> menu);

    //    @Mapping(source = "type", target = "type", qualifiedByName = "menuTypeMapping")
    @Mapping(source = "status", target = "status", qualifiedByName = "statusMapping")
    SysMenuVo dto2Vo(SysMenuDTO dto);
    List<SysMenuVo> dto2Vo(List<SysMenuDTO> dto);

    SysMenuDTO addReq2Dto(SysMenuAddReq addReq);
    SysMenuDTO editReq2Dto(SysMenuEditReq editReq);
}
